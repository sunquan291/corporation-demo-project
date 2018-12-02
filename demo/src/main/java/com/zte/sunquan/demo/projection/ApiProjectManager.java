package com.zte.sunquan.demo.projection;

import com.google.common.collect.Maps;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import java.io.InputStream;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by 10184538 on 2017/1/7.
 */
public class ApiProjectManager {
    /**
     * project map
     */
    private Map<String, String> apiPrjPropMap;

    /**
     * api-impl map
     */
    private Map<String, Class<?>> apiPrjMap;
    /**
     * api-instance
     */
    private Map<String, Object> apiPrjInstMap;

    public ApiProjectManager() {
        this.apiPrjPropMap = Maps.newHashMap();
        this.apiPrjMap = Maps.newHashMap();
        this.apiPrjInstMap = Maps.newConcurrentMap();
        loadSetting();
    }

    public synchronized void loadSetting() {
        //加载属性
        loadProperties();
        loadProjections();
    }

    private void loadProperties() {

        XMLConfiguration cfg = new XMLConfiguration();

        cfg.setRootElementName("properties");
        cfg.setAttributeSplittingDisabled(true);
        try {
            cfg.load(getClass().getResourceAsStream("/api-projection-property.xml"));
        } catch (ConfigurationException e) {
            throw new IllegalStateException("api projection property xml file missing, unable to load it", e);
        }

        for (HierarchicalConfiguration propConfig : cfg.configurationsAt("property")) {
            String name = propConfig.getString("[@name]");
            String value = propConfig.getString("[@value]");
            if (name == null || name.isEmpty() || value == null) {
                continue;
            }
            apiPrjPropMap.put(name, value);
        }
    }

    private void loadProjections() {
        ClassPathSearcher searcher = new ClassPathSearcher();
        searcher.search(
                ClassPathSearcher.SEARCH_FROM,
                "api-projection.xml",
                inputStream -> this.loadProjections(inputStream, name -> {
                    try {
                        return getClass().getClassLoader().loadClass(name);
                    } catch (ClassNotFoundException e) {
//                        logger.error("projection error for class not found {}", e);
                    }
                    return null;
                }));
    }
    private void loadProjections(InputStream stream, Function<String, Class<?>> classLoader) {

        XMLConfiguration cfg = new XMLConfiguration();

        cfg.setRootElementName("projections");
        cfg.setAttributeSplittingDisabled(true);
        try {
            cfg.load(stream);
        } catch (ConfigurationException e) {
            throw new IllegalStateException("api projections xml file missing, unable to load it", e);
        }

        for (HierarchicalConfiguration topicConfig : cfg.configurationsAt("topic")) {
            String topicName = topicConfig.getString("[@name]");
            if (topicName == null || topicName.isEmpty()) {
                continue;
            }
            for (HierarchicalConfiguration groupConfig : topicConfig.configurationsAt("group")) {
                String groupName = groupConfig.getString("[@name]");
                String extendsNames = groupConfig.getString("[@extends]");
                if (groupName == null || groupName.isEmpty()) {
                    continue;
                }
                //TODO handle "extends" logic to inherite and reuse settings of other groups.

                for (HierarchicalConfiguration prjConfig : groupConfig.configurationsAt("projection")) {
                    String api = prjConfig.getString("[@api]");
                    String impl = prjConfig.getString("[@impl]");
                    if (api == null || api.isEmpty() || impl == null || impl.isEmpty()) {
                        continue;
                    }

//                    logger.info("projection ==> TOPIC:{} GROUP:{} API:{} IMPL:{}", topicName, groupName, api, impl);
                    apiPrjMap.put(
//                            new ApiProjectKeyBuilder()
//                                    .withApiClass(classLoader.apply(api))
//                                    .withTopic(topicName)
//                                    .withGroup(groupName)
//                                    .build(),
                            topicName+","+groupName+","+api,
                            classLoader.apply(impl));

                }
            }
        }
    }

    public <T> T getInstance(String key){
        return (T) apiPrjInstMap.computeIfAbsent(key, k -> createInstance(k));
    }
    public <T> T createInstance(String key){
        Class<?> classImpl = apiPrjMap.get(key);
        if (classImpl == null) {
            return null;
        }
        try {
            return (T)classImpl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getApiPrjPropMap() {
        return apiPrjPropMap;
    }

    public Map<String, Class<?>> getApiPrjMap() {
        return apiPrjMap;
    }

    public Map<String, Object> getApiPrjInstMap() {
        return apiPrjInstMap;
    }
}

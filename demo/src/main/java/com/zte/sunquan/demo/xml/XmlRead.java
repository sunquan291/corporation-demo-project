package com.zte.sunquan.demo.xml;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.EnvironmentConfiguration;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.configuration.reloading.ReloadingStrategy;
import org.apache.commons.configuration.tree.xpath.XPathExpressionEngine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by 10184538 on 2017/6/25.
 */
public class XmlRead {
    private String configFile = "/config.xml";
    private String rootElementName = "properties";
    private XMLConfiguration cfg;

    public void loadCfg(Class cls) {
        cfg = new XMLConfiguration();
        cfg.setRootElementName(rootElementName);
        cfg.setAttributeSplittingDisabled(true);
        try {
            cfg.load(cls.getResourceAsStream(configFile));
            FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
            strategy.setRefreshDelay(1);
            cfg.setFileName("config.xml");//如果设置了reloading-strategy则必须设置文件
            cfg.setReloadingStrategy(strategy);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void loadConfig(XMLConfiguration rootCfg) {
        for (HierarchicalConfiguration cfg : rootCfg.configurationsAt("property")) {
            System.out.println(cfg.getString("[@name]"));
        }
    }

    @Before
    public void init() {
        loadCfg(XmlRead.class);
    }

    @Test
    public void getCommonConfig() {
        Assert.assertEquals("default-topic", cfg.getString("property.[@name]"));
        Assert.assertEquals("China", cfg.getString("property.country"));
        Assert.assertEquals("China", cfg.getString("property(0).country"));
        Assert.assertEquals("Japan", cfg.getString("property(1).country"));
    }

    @Test
    public void getConfigByXPath() throws ConfigurationException {
        cfg.setExpressionEngine(new XPathExpressionEngine());
        Assert.assertEquals("China", cfg.getString("property[@name = 'default-topic']/country"));
        Assert.assertEquals("Japan", cfg.getString("property[num>11]/country"));
        Assert.assertEquals("Japan", cfg.getString("property[last()]/country"));
    }

    @Test
    public void getEnvironmentConfig() {
        EnvironmentConfiguration config = new EnvironmentConfiguration();
        Assert.assertEquals("C:\\Program Files\\Java\\jdk1.8.0_91", config.getString("JAVA_HOME"));
    }

    @Test
    public void whenConfigChange() throws InterruptedException, ConfigurationException {
        cfg = new XMLConfiguration("config.xml");
        FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
        strategy.setRefreshDelay(1);
        cfg.setReloadingStrategy(strategy);
        while (true) {
            System.out.println(cfg.getString("property.country"));
            TimeUnit.SECONDS.sleep(2);
        }
    }

    @Test
    public void whenConfigChangeListener() throws InterruptedException, ConfigurationException {
        cfg = new XMLConfiguration("config.xml");
        FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
        strategy.setRefreshDelay(1);
        cfg.setReloadingStrategy(strategy);
        cfg.addConfigurationListener(new ConfigurationListener() {
            @Override
            public void configurationChanged(ConfigurationEvent event) {
                if (!event.isBeforeUpdate())
                {
                    // only display events after the modification was done
                    System.out.println("Received event!");
                    System.out.println("Type = " + event.getType());
                    if (event.getPropertyName() != null)
                    {
                        System.out.println("Property name = " + event.getPropertyName());
                    }
                    if (event.getPropertyValue() != null)
                    {
                        System.out.println("Property value = " + event.getPropertyValue());
                    }
                }
            }
        });
        while (true) {
            System.out.println(cfg.getString("property.country"));
            TimeUnit.SECONDS.sleep(2);
        }
    }

}

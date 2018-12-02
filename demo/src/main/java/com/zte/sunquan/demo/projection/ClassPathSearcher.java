package com.zte.sunquan.demo.projection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by 10043533 on 2016-10-14.
 */
public final class ClassPathSearcher{
    private static Logger logger = LoggerFactory.getLogger(ClassPathSearcher.class);
    public static final String SEARCH_FROM = "CLASS_PATH";
    private static final ApiProjectSearcher[] SEARCHERS =
            new ApiProjectSearcher[]{new JarFileSearcher(), new PathFileSearcher()};

    public boolean match(String searchKey) {
        if (searchKey != null) {
            return SEARCH_FROM.equals(searchKey);
        }
        return false;
    }

    public void search(String searchFrom, String searchFileName, Consumer<InputStream> consumer) {
        if (searchFrom == null || searchFrom.isEmpty() ||
                searchFileName == null || searchFileName.isEmpty() ||
                consumer == null){
            throw new IllegalArgumentException("invalid search parameter");
        }

        if (!match(searchFrom)){
            return;
        }
        RuntimeMXBean rmb=(RuntimeMXBean) ManagementFactory.getRuntimeMXBean();
        String classPath = rmb.getClassPath();
        String[] paths = classPath.split(System.getProperties().getProperty("path.separator"));

        Arrays.stream(paths).forEach(path -> {
            if (path != null && !path.isEmpty()){
                logger.info("class path : {}", path);
                Arrays.stream(SEARCHERS).forEach(s -> s.search(path, searchFileName, consumer));
            }
        });
    }
}

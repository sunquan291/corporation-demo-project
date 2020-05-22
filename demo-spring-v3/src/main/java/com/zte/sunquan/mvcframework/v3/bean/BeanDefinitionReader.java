package com.zte.sunquan.mvcframework.v3.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @Author: Livio
 * @Date: 2020/5/6 23:07
 */
public class BeanDefinitionReader {
    private Properties properties = new Properties();
    private String scanPackage;

    public BeanDefinitionReader(String configPath) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/" + configPath);
        try {
            properties.load(resourceAsStream);
            scanPackage = properties.getProperty("scanPackage");
            System.out.println("ScanPackage:" + scanPackage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SQBeanDefinition> loadBeanDefinitions() {

        return null;
    }
}

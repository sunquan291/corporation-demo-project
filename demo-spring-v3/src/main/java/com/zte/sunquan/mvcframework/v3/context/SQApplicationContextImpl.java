package com.zte.sunquan.mvcframework.v3.context;

import com.zte.sunquan.mvcframework.v3.bean.BeanDefinitionReader;
import com.zte.sunquan.mvcframework.v3.bean.SQBeanDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Livio
 * @Date: 2020/5/6 23:08
 */
public class SQApplicationContextImpl implements SQApplicationContext {
    private Map<String, SQBeanDefinition> beanDefinitionMap = new HashMap<>();
    private BeanDefinitionReader beanDefinitionReader;

    public SQApplicationContextImpl(String configPath) {
        beanDefinitionReader = new BeanDefinitionReader(configPath);
        //1、加载扫描配置
        List<SQBeanDefinition> beanDefinitionList = beanDefinitionReader.loadBeanDefinitions();
        //2、保存beanDefinition

        //4.IOC

        //5.DI
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public Object getBean(Class beanClsName) {
        return this.getBean(beanClsName.getName());
    }
}

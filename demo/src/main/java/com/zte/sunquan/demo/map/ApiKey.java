package com.zte.sunquan.demo.map;

import java.util.Objects;

/**
 * Created by 10184538 on 2017/4/12.
 */
public class ApiKey {
    private Class<?> apiClass;
    private String topic;
    private String group;
    private Object[] parameters;

    public Class<?> getApiClass() {
        return apiClass;
    }

    public void setApiClass(Class<?> apiClass) {
        this.apiClass = apiClass;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiKey that = (ApiKey) o;
        return Objects.equals(apiClass.getName(), that.apiClass.getName()) &&
                Objects.equals(topic, that.topic) &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiClass.getName(), topic, group);
    }
}

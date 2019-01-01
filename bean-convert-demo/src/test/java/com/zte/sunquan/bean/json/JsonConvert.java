package com.zte.sunquan.bean.json;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert {
    @Test
    public void testA() throws IOException {
        Dog dog = new Dog();
        dog.setAge(100);
        dog.setName("abc");
        //{"typeName":"dog","name":"abc","age":100}
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dog);
        System.out.println(json);
        Animal animal = mapper.readValue(json, Animal.class);
        System.out.println(animal);
    }

    @Test
    public void testB() throws IOException {
        Cat cat = new Cat();
        cat.setAge(100);
        cat.setName("abc");
        //{"type":"dog","name":"abc","age":100}
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(cat);
        System.out.println(json);
        //String content = "{\"type\":\"dog\",\"name\":\"abc\",\"age\":100,\"a\":1}";//没有TYPE则报错
        String content = "{\"type\":\"dog\",\"name\":\"abc\"}";//没有TYPE则报错
        Animal animal = mapper.readValue(content, Dog.class);
        System.out.println(animal);

        //JSON数据多于模型  转换有问题 （@JsonIgnoreProperties(ignoreUnknown=true)）
        //JSON数据少于模型  转换无问题
        //@JsonIgnore  JSON数据转换成模型时 忽略JSON该字段数据
        //@JsonIgnore  模型转换成JSON数据时 忽略模型中该字段数据

    }
}

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
}

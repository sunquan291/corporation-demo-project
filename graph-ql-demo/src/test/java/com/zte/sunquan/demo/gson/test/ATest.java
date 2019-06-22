package com.zte.sunquan.demo.gson.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.zte.sunquan.demo.model2.Cat;
import com.zte.sunquan.demo.model2.Fish;

/**
 * ATest class
 *
 * @author 10184538
 * @date 2019/6/18
 */
public class ATest {
    @Test
    public void test() throws IOException {
        Person person = new Person();
        Zoo zoo = new Zoo();
        zoo.setAnimals(Lists.newArrayList(new Cat(1), new Fish(2)));
        person.setZoo(zoo);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
        Person person1 = mapper.readValue(json, Person.class);
        System.out.println(person1);

//        Gson gson = new Gson();
//        String content = gson.toJson(person);
//        Person person1 = gson.fromJson(content, Person.class);
//        System.out.println(person1);
    }

    @Test
    public void testA(){
        List<String> a1=Lists.newArrayList("1","2","3");
        List<String> a2=Lists.newArrayList("1","3","2");
        System.out.println(a1.containsAll(a2));
        System.out.println(a2.containsAll(a1));
    }
}

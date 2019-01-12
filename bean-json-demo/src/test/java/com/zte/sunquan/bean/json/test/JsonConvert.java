package com.zte.sunquan.bean.json.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

public class JsonConvert {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testMapConvert() throws IOException {
        Map<String, String> maps = new HashMap<>();
        maps.put("overlay", "123");
        maps.put("underlay", "456");
        String json = mapper.writeValueAsString(maps);
        String expect = "{\"overlay\":\"123\",\"underlay\":\"456\"}";
        Assert.assertEquals(json, expect);
    }

    @Test
    public void testDogConvert() throws IOException {
        Dog dog = new Dog();
        dog.setName("dog001");
        dog.setAge(3);
        String json = mapper.writeValueAsString(dog);
        String expect = "{\"type\":\"dog\",\"name\":\"dog001\",\"age\":3}";
        Assert.assertEquals(json, expect);//序列化JSON字串时,生成type属性
        Animal animal = mapper.readValue(json, Animal.class);
        Assert.assertTrue(animal instanceof Dog);//反序列化时，根据type转成真实类型

        expect = "{\"name\":\"dog001\",\"age\":3}";
        animal = mapper.readValue(expect, Animal.class);
        System.out.println(animal);
    }

    @Test(expected = InvalidTypeIdException.class)
    public void testAnimalConvert() throws IOException {
        String json = "{\"name\":\"dog001\"}";//不指定Type则无法转换
        Animal animal = mapper.readValue(json, Animal.class);
        System.out.println(animal);
    }


    @Test(expected = UnrecognizedPropertyException.class)
    public void testDogConvertSenior() throws IOException {
        //1.JSON数据少于模型  转换无问题
        String json = "{\"type\":\"dog\"}";
        Animal animal = mapper.readValue(json, Animal.class);
        Assert.assertTrue(animal instanceof Dog);

        //2.JSON字串数据多于模型  转换有问题
        json = "{\"type\":\"dog\",\"name\":\"dog001\",\"age\":3,\"extra\":0}";
        mapper.readValue(json, Animal.class);
        //可以通过在模型中增加@JsonIgnoreProperties(ignoreUnknown=true)注解忽略未知属性

        //3.模型中字段定义@JsonIgnore注解时
        //JSON字串转换成模型时 忽略JSON该字段数据
        //模型转换成JSON字串时 忽略模型中该字段数据

        //4. @JsonInclude(JsonInclude.Include.NON_NULL)
        //表示模型转JSON字串时，如果为null，则不显示
    }

    @Test
    public void testJackSonBug() throws IOException {
        //Cat中定义了属性nRouteId,并通过@JsonProperty("n-route-id")重定义
        Cat cat = new Cat();
        cat.setAge(2);
        cat.setNRouteId("none");
        String json = mapper.writeValueAsString(cat);
        System.out.println(json);
        //{"type":"cat","name":null,"age":2,"nrouteId":"none","n-route-id":"none"}
        //返回JSON字串中出现了nrouteId和n-route-id两个数据

        //如果单独使用@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)不存在问题
        //但针对该种驼峰的定义，会转换成nroute-id格式

        //如果KebabCaseStrategy与JsonProperty一起定义 正常jsonProperty优先级高，但上面依旧出现了两种不同命名字串
        //根据上述情况，解决办法
        //1.存在单字母的驼峰命名,使用了KebabCaseStrategy指定,则不能通过JsonProperty指定
        //2.单字母的驼峰命名属性上不加JsonProperty,类上也不使用KebabCaseStrategy
        //2.避免使用单字母的命名
    }
}

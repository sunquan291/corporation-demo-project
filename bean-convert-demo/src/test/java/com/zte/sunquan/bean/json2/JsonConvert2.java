package com.zte.sunquan.bean.json2;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert2 {
    @Test
    public void testA() throws IOException {
        Car car = new Car();
        car.setCarName("abc");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);
        System.out.println(json);

        String content = "{\"type\":\"dog\",\"name\":\"abc\",\"age\":100}";//没有TYPE则报错
        Vechile vechile = mapper.readValue(json, Vechile.class);
        System.out.println(vechile);


    }

    @Test
    public void testB() throws IOException {
        Car car = new Car();
        car.setCarName("abc");

        Store store = new Store();//使用封装，
        store.setName("134");
        store.getExtension().put("car", car);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(store);
        System.out.println(json);
        //{"name":"134","extension":{"car":{"class":"car","carName":"abc"}}}
        //令人感到奇怪的使用用Store进行封装时，转换都正常了
        //TestA中未进行封装{"class":"com.zte.sunquan.bean.json2.Car","carName":"abc"}序列化JSON却是类名
        //反序列化会出错
        Store store1 = mapper.readValue(json, Store.class);
        System.out.println(store1);
    }

    @Test
    public void testC() throws IOException {
        Car car = new Car();
        car.setCarName("abc");
        car.setVirtual(false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);
        System.out.println(json);
        String content="{\"class\":\"com.zte.sunquan.bean.json2.Car\",\"carName\":\"abc\",\"tels\":[{}],\"virtual\":false}";
        Car car1 = mapper.readValue(content, Car.class);
        System.out.println(car1);
    }
}

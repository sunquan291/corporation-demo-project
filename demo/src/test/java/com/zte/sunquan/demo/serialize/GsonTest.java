package com.zte.sunquan.demo.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * Created by 10184538 on 2017/2/21.
 */
public class GsonTest {
    @Test
    public  void test1() {
        String response = "{\n" +
                "    \"error\": 0,\n" +
                "    \"status\": \"success\",\n" +
                "    \"date\": \"2014-05-10\",\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"currentCity\": \"南京\",\n" +
                "            \"weather_data\": [\n" +
                "                {\n" +
                "                    \"date\": \"周六(今天, 实时：19℃)\",\n" +
                "                    \"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/dayu.png\",\n" +
                "                    \"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/dayu.png\",\n" +
                "                    \"weather\": \"大雨\",\n" +
                "                    \"wind\": \"东南风5-6级\",\n" +
                "                    \"temperature\": \"18℃\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"date\": \"周日\",\n" +
                "                    \"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/zhenyu.png\",\n" +
                "                    \"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/duoyun.png\",\n" +
                "                    \"weather\": \"阵雨转多云\",\n" +
                "                    \"wind\": \"西北风4-5级\",\n" +
                "                    \"temperature\": \"21 ~ 14℃\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Gson gson = new Gson();
        Status status = gson.fromJson(response, Status.class);
        System.out.println(status.getStatus());
    }
    @Test
    public void  test2(){
        Device device = new Device();
        device.setName("device01");
        Network network = new Network();
        network.setName("network1");
        network.setNode(device);
        Gson gson = new Gson();
        String res = gson.toJson(network);
        System.out.println(res);
        String response = "{\"name\":\"network1\",\"node\":{\"name\":\"device01\"}}";
//        Network n = gson.fromJson(response, Network.class);
//        System.out.println(n.getName());
        gson = new GsonBuilder().registerTypeAdapter(Node.class,
                new NodeDeserializer()).create();
        Network n2=gson.fromJson(response, Network.class);
        System.out.println(n2.getName());
        System.out.println(n2.getNode().getName());
    }
    @Test
    public void test3(){
        Gson gson = new Gson();
        String response = "{\"name\":\"network1\",\"node\":{\"name\":\"device01\"}}";
//        Network n = gson.fromJson(response, Network.class);
//        System.out.println(n.getName());
        gson = new GsonBuilder().registerTypeAdapter(Node.class,
                new Device()).create();
        Network n2=gson.fromJson(response, Network.class);
        System.out.println(n2.getName());
        System.out.println(n2.getNode().getName());

    }
}

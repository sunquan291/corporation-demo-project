package com.zte.sunquan.demo.biMap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by 10184538 on 2017/4/15.
 */
public class MapTest {
    BiMap<String,String> map= HashBiMap.create();
    Map<String,Object> map2=Maps.newConcurrentMap();

    public void tcpConnect(String channel){
        map2.put(channel,"");
    }
    public void deviceConnect(String dataPath){

    }
    @Test
    public void test(){
        map.put("ch1","datapath1");
        map.put("ch2","datapath2");
        map.put("ch3","datapath3");


    }
}

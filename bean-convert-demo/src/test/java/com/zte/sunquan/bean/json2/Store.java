package com.zte.sunquan.bean.json2;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Store {
    private String name;
    private Map<String, Vechile> extension = new HashMap<>();
}

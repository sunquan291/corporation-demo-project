package com.zte.sunquan.demo.graph.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String gender;
    private Vehicle vehicle;
}

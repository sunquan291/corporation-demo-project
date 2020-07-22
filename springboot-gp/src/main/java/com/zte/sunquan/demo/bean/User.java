package com.zte.sunquan.demo.bean;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    private Long id;
    private String name;
    private int age;
}

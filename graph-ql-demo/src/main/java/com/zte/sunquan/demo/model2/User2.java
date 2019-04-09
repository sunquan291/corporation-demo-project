package com.zte.sunquan.demo.model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User2 class
 *
 * @author 10184538
 * @date 2019/4/8
 */
@Data
@AllArgsConstructor
public class User2 implements Serializable {
    private int id;
    private int age;
    private String userName;
    private List<Dog> dogs;

    private Position type;

    public User2(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void addDog(Dog dog) {
        if (dogs == null) {
            dogs = new ArrayList<>();
        }
        dogs.add(dog);
    }

}

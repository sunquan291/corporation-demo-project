package com.zte.sunquan.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10184538 on 2017/10/20.
 */
@XmlRootElement(name = "person")
public class Person {
    @XmlAttribute(name = "name")
    public String name;
    @XmlAttribute(name = "age")
    public int age;


//    public Person() {
//    }

    private List<String> hobby=new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "hobbys")
    @XmlElement(name = "hobby")
    public List<String> getHobby() {
        return hobby;
    }

    public void addHobby(String hobby) {
        this.hobby.add(hobby);
    }
}

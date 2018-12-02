package com.zte.sunquan.demo.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by 10184538 on 2017/3/18.
 */
public class MulitMapTest {
    class Student{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    @Test
    public void test(){
        Multimap<String,Student> students= ArrayListMultimap.create();
        for(int i=0;i<10;i++){
            students.put("class1",new Student("name"+i));
        }
        Collection<Student> class1Students = students.get("class1");
        class1Students.add(new Student("sunquan"));
        students.get("class1").forEach(System.out::println);
    }

}

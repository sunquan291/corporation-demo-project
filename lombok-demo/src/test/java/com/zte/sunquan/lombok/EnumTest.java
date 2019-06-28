package com.zte.sunquan.lombok;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.junit.Test;

import com.zte.sunquan.lombol.Gender;

/**
 * EnumTest class
 *
 * @author 10184538
 * @date 2019/6/27
 */
public class EnumTest {
    @Test
    public void testA() {
        System.out.println(Gender.Female.getValue());
        //不能用GIRl
        Gender female = Gender.valueOf("Female");
        System.out.println(female.getValue());
    }
}

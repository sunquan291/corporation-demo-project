package com.zte.sunquan.demo.reg;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 10184538 on 2017/3/13.
 */
public class RegTest {
    public static void main(String[] args) {
        String str = "!!！？？!!!!%*）%￥！KTV去符号标号！！当然,，。!!..**半角";
        System.out.println(str);
        String str1 = str.replaceAll("[\\pP]", "");
        System.out.println("str1:" + str1);

        String str4 = str.replaceAll("\\p{Punct}+", "");
        System.out.println("str2:" + str4);
    }

    @Test
    public  void getDemo() {
        String str = "ni hao ma ye xu ceng jing de ni yao hao yi xie !";
        System.out.println(str);
        String regex = "\\b[a-zA-Z]{3}\\b";
        Pattern p = Pattern.compile(regex);//将正则表达式封装成对象
        Matcher m = p.matcher(str);//将正则对象和要操作的字符串相关联
        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.start() + "----" + m.end());
        }
    }
}

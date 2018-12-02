package com.zte.sunquan.demo.ibeet;

import com.google.common.collect.Maps;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by 10184538 on 2017/3/24.
 */
public class BeetTest {
    @Test
    public void test1() throws IOException{
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        String str = t.render();
        System.out.println(str);
    }
    @Test
    public void test2() throws IOException{
        String root = System.getProperty("user.dir")+ File.separator+"target\\classes\\template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/temp.txt");
        t.binding("name", "gender");
        t.binding("type", "int");
        String str = t.render();
        System.out.println(str);
    }
    @Test
    public void test3() throws IOException{
        String root = System.getProperty("user.dir")+ File.separator+"target\\classes\\template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/temp.txt");
        t.binding("name", "persons");
        t.binding("type", "List<String>");
        String str = t.render();
        System.out.println(str);
    }
}

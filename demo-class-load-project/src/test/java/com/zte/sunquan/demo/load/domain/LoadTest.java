package com.zte.sunquan.demo.load.domain;

import java.io.FileInputStream;
import java.net.URL;

import org.junit.Test;

/**
 * Created by 10184538 on 2018/5/31.
 */
public class LoadTest {
    @Test
    public void loadClass() throws Exception {
//        E:/sunquan-new-project/demo-class-load-project/target/test-classes/
        URL resource = User.class.getResource(".");
        String path = resource.getPath().replace("test-classes", "classes");
        String userPath = path + "User.class";
        FileInputStream in = new FileInputStream(userPath);
        byte[] original = new byte[in.available()];
        in.read(original);
        in.close();
        SQClassLoader loader = new SQClassLoader();
        //这种方式直接转，会报类型不匹配(class文件里包含了加载器信息)
        Class hello = loader.defineClass(original, null);
        Object o = hello.newInstance();
        //需要特别注意的是o的类型是接口Person
        // 类似通过这种方式会造成真实类信息被擦除，而接口信息会保留
        //如使用o instanceof User则返回false
        if (o instanceof Person) {
            ((Person) o).sayHello("sunquan");
        }
    }

    @Test
    public void loadClassSenior() {
        URL resource = User.class.getResource(".");
        String path = resource.getPath().replace("test-classes", "classes");
        String userPath = path + "User.class";
    }
}

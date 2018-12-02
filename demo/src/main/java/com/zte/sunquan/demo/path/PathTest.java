package com.zte.sunquan.demo.path;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 * Created by 10184538 on 2017/3/18.
 */
public class PathTest {
    @Test
    public void testProjectPath() throws IOException {
        // 第一种：获取类加载的根路径   E:\sunquan-project\demo\target\test-classes
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);

        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录
        // E:\sunquan-project\demo\target\classes\com\zte\sunquan\demo\path
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        // 第二种：获取项目路径    E:\sunquan-project\demo
        File directory = new File("");// 参数为空
        System.out.println(directory.exists());
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);


        // 第三种：  file:/E:/sunquan-project/demo/target/test-classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);


        // 第四种： E:\sunquan-project\demo
        System.out.println(System.getProperty("user.dir"));
         /*
          * 结果： C:\Documents and Settings\Administrator\workspace\projectName
          * 获取当前工程路径
          */

        // 第五种：  获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
    }

    @Test
    public void testFileAccess3() throws IOException {
        URL resource = FileCaptureTest.class.getResource("/device.yang");
        System.out.println(resource);
    }

    @Test
    public void filePath() throws IOException {
        File file = new File(".\\test.txt");
        System.out.println(file.getPath());//.\test.txt
        System.out.println(file.getAbsolutePath());//E:\sunquan-project\demo\.\test.txt
        System.out.println(file.getCanonicalPath());//E:\sunquan-project\demo\test.txt
    }

    @Test
    public void code() throws UnsupportedEncodingException {
        //default utf-8
        String s = "当";
        System.out.println(new String(s.getBytes()));
        System.out.println(new String(s.getBytes("unicode"),"unicode"));
    }
}

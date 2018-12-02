package com.zte.sunquan.demo.security;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Created by 10184538 on 2016/11/17.
 */
public class FileSecurityManagerSenior {

    public static void testFilePremission0(){
        URL path=FileSecurityManagerSenior.class.getClassLoader().getResource("file0.policy");
        System.setProperty("java.security.policy",path.getPath());
        System.setSecurityManager(new SecurityManager());

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:\\AbstractDriverEventHandler.java");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
    public static void testFilePremission1(){
        URL path=FileSecurityManagerSenior.class.getClassLoader().getResource("file1.policy");
        System.setProperty("java.security.policy",path.getPath());
        System.setSecurityManager(new SecurityManager());

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:\\AbstractDriverEventHandler.java");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
    public static void testFilePremission2(){
        URL path=FileSecurityManagerSenior.class.getClassLoader().getResource("file2.policy");
        System.setProperty("java.security.policy",path.getPath());
        System.setSecurityManager(new SecurityManager());

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\20150410184538.id");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

//    public static void testFilePremission3(){
//        URL path=FileSecurityManagerSenior.class.getClassLoader().getResource("file3.policy");
//        System.setProperty("java.security.policy",path.getPath());
//        System.setSecurityManager(new SecurityManager());
//        SecurityManager securityManager=System.getSecurityManager();
//        securityManager.checkPermission(new AppPermission("hello","read"));
//    }

    public static void main(String[] args) {
//        testFilePremission0();//no premission
//        testFilePremission1();//with premission
        testFilePremission2();//in ide environment can not check success
//        testFilePremission3();
    }
}

package com.zte.sunquan.demo.security;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 10184538 on 2016/11/15.
 * must set java run vm arguments:
 * -Djava.security.manager -Djava.security.policy==E:/demo/src/main/resources/filepolicy.policy
 */
public class FileSecurityManager {


    public static void testFilePremission() {
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

    public static void main(String[] args) {
        /**has pression to read file with filepolicy.policy*/
        testFilePremission();
    }
}

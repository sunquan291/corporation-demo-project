package com.zte.sunquan.demo.path;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by 10184538 on 2017/6/7.
 */
public class FileCapture {
    public static void testFileAccess1() {
        String filePath = "E:\\ttp-table-map.xml";
        String filePath2 = "E:/ttp-table-map.xml";
        String filePath3 = "E:" + File.separator + "ttp-table-map.xml";
        File f = new File(filePath);
        Assert.assertTrue(f.exists());
        f = new File(filePath2);
        Assert.assertTrue(f.exists());
        f = new File(filePath3);
        Assert.assertTrue(f.exists());
    }

    public static void testFileAccess2() throws IOException {
        InputStream is = FileCapture.class.getResourceAsStream("/device.yang");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void testFileAccess3() throws IOException {
        InputStream is = FileCapture.class.getResourceAsStream("../../../../../../device.yang");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void testFileAccess4() throws IOException {
        URL resource = FileCapture.class.getResource("/device.yang");
        //file:/E:/sunquan-project/oscp-yang-utils/yang-test/target/test-classes/device.yang
        System.out.println(resource);
        String path = FileCapture.class.getResource("/").getPath();
        ///E:/sunquan-project/oscp-yang-utils/yang-test/target/test-classes/
        System.out.println(path);
        File f = new File(path);
        Assert.assertTrue(f.isDirectory());
        Assert.assertTrue(f.list().length == 2);
        Assert.assertTrue(f.list()[1].equals("device.yang"));
        f = new File(path + File.separator + "device.yang");
        Assert.assertTrue(f.isFile());
    }
}

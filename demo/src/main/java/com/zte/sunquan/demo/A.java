package com.zte.sunquan.demo;

import akka.actor.Address;
import akka.remote.security.provider.AES256CounterSecureRNG;
import com.sun.xml.bind.api.JAXBRIContext;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by 10184538 on 2017/5/9.
 */
public class A implements B {
//        static {
//        try {
//            throw  new ExceptionInInitializerError("no");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    private String a;

    public List<Integer> getList() {
        return null;
    }

    @TestCase(value = "a")
    @TestCase(value = "b")
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TestCase[] getAS = A.class.getMethod("getA").getAnnotationsByType(TestCase.class);
        System.out.println(getAS.length);
        System.out.println(false | true);
        System.out.println(true | true);
        System.out.println(true | false);
        System.out.println(false | false);
    }

    @Test
    public void abc() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBRIContext.newInstance(NetconfState.class);
//        System.out.println(jaxbContext);

//        Class<A> aClass = A.class;
//        new A();
//        new Schemas();
        int len = 10;
        while (len >= 0) {
            if (len >= 0)
                throw new IOException("aaa");//中断程序
            len = -1;
        }


    }
    @Test
    public void testShowProperties(){
        final Properties p = System.getProperties();
        final Enumeration e = p.keys();
        while (e.hasMoreElements())
        {
            final String prt = (String) e.nextElement();
            final String prtvalue = System.getProperty(prt);
            System.out.println(prt + ":" + prtvalue);
        }
    }
    @Test
    public void testActorAddressIsSame(){
        Address address1=new Address("tcp","a1","127.0.0.1",2550);
        Address address2=new Address("tcp","a1","127.0.0.1",2550);
        Map<Address,String> map=new HashMap<>();
        map.put(address1,"2");
        map.put(address2,"3");
        Assert.assertTrue(map.size()==1);
    }

}

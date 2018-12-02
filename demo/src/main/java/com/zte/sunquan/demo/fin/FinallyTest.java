package com.zte.sunquan.demo.fin;

/**
 * Created by 10184538 on 2017/1/7.
 */
public class FinallyTest {
    private static int result=-1;
    public static int test(){
         result=-1;
        try{
            System.out.println("hello,world");
            int t=1/0;
//            throw new IllegalArgumentException("test");
        }catch (Exception e){
            System.out.println("catch");
            result=0;
            return result;
        }finally {
            System.out.println("finally");
            result=1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(result);
    }

}

package com.zte.sunquan.demo.eventloop;

/**
 * Created by 10184538 on 2017/4/15.
 */
public class EventLoopTest {

    public static void main(String[] args) {
        DefaultEventDispatch eventDispatch = new DefaultEventDispatch();
        new Thread(()->{
            while (true){
                eventDispatch.postEvent("hello,world");
            }
        }).start();
    }

}

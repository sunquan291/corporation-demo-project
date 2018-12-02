package com.zte.sunquan.demo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by sunquan on 2018/4/9.
 */
public class UserEvent {
    private String value;

    public synchronized void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static final EventFactory<UserEvent> FACTORY = new EventFactory<UserEvent>() {
        @Override
        public UserEvent newInstance() {
            return new UserEvent();
        }
    };
    public void exe(){
        init();
    }
    public void init(){
        System.out.println("UserEvent init");
    }
}

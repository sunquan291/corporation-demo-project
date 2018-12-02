package com.zte.sunquan.demo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by sunquan on 2018/4/9.
 */
public class UserEvent2 extends UserEvent{
    private String value;

    public synchronized void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static final EventFactory<UserEvent2> FACTORY = new EventFactory<UserEvent2>() {
        @Override
        public UserEvent2 newInstance() {
            return new UserEvent2();
        }
    };

    public void invoke(){
        super.exe();
        System.out.println("UserEvent2 invoke");
    }
    public void init(){
        System.out.println("UserEvent2 init");
    }

    public static void main(String[] args) {
        UserEvent2 u=new UserEvent2();
        u.invoke();
    }
}

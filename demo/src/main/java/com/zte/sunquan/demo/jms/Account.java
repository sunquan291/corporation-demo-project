package com.zte.sunquan.demo.jms;

import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 10184538 on 2017/9/30.
 */
public class Account extends NotificationBroadcasterSupport implements AccountMBean {
    private AtomicLong sequenceNumber = new AtomicLong(1);
    private String name;

    @Override
    public void setName(String name) {
        AttributeChangeNotification notification = new AttributeChangeNotification(
                this, sequenceNumber.getAndIncrement(),
                System.currentTimeMillis(),
                AttributeChangeNotification.ATTRIBUTE_CHANGE,
                "name",
                "java.lang.String",
                this.name,
                name
        );
        this.name = name;
        super.sendNotification(notification);
    }

    @Override
    public String getName() {
        return name;
    }
}

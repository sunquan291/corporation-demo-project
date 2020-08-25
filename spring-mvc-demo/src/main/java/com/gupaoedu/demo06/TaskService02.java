package com.gupaoedu.demo06;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Service
public class TaskService02 {

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println("current Time:"+Thread.currentThread().getName()+new Date());
    }
}

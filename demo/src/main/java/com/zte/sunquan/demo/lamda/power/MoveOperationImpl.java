package com.zte.sunquan.demo.lamda.power;

import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2018/5/25.
 */
public class MoveOperationImpl implements MoveOperation{
    @Override
    public void move(int x) {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

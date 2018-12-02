package com.zte.sunquan.demo.lamda.power;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2018/3/9.
 */
public class LpTest {
    public int times = 10000;

    @Test
    public void m1() {
        List<MoveOperation> list = Lists.newArrayList();
        for (int i = 0; i < times; i++) {
            list.add(new MoveOperation() {
                @Override
                public void move(int x) {
//                    System.out.println("m1--" + x);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        long start = System.nanoTime();
        for (MoveOperation m : list) {
            m.move(1);
        }
        System.out.println("use:" + (System.nanoTime() - start)/1000);

    }

    @Test
    public void m2() {
        List<MoveOperation> list = Lists.newArrayList();
        for (int i = 0; i < times; i++) {
            list.add(new MoveOperationImpl());
        }
        long start = System.nanoTime();
        for (MoveOperation m : list) {
            m.move(1);
        }
        System.out.println("use:" + (System.nanoTime() - start)/1000);

    }

    @Test
    public void m3() {
        List<MoveOperation> list = Lists.newArrayList();
        for (int i = 0; i < times; i++) {
            list.add((x)->{
//                System.out.println("m2--" + x);
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        long start = System.nanoTime();
        for (MoveOperation m : list) {
            m.move(1);
        }
        System.out.println("use:" + (System.nanoTime() - start)/1000);
    }

    @Test
    public void testAll(){
        m3();
        m1();
        m2();
    }
}

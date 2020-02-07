package com.zte.sunquan.demo.watch;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class WatchDog {

    //默认10s检查一次
    private static final int CHECK_CYCLE = 5000;
    private Map<Thread, Consumer> threads = new ConcurrentHashMap<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    public void addMonitor(Thread th, Consumer<Thread> consumer) {
        threads.put(th, consumer);
    }


    public void start() {
        executorService.submit(() -> {
            while (true) {
                Thread.sleep(CHECK_CYCLE);
                Iterator<Map.Entry<Thread, Consumer>> iterator = threads.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Thread, Consumer> next = iterator.next();
                    if (!next.getKey().isAlive()) {
                        //此处根据状态使用不同的策略
                        next.getValue().accept(next.getKey());
                    }
                }
            }
        });
    }

    private WatchDog() {

    }

    public static WatchDog getInstance() {
        return Singleton.INSTANCE.getInstance();
    }


    private static enum Singleton {
        INSTANCE;
        private WatchDog singleton;

        private Singleton() {
            singleton = new WatchDog();
        }

        public WatchDog getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        WatchDog.getInstance().start();
//        Thread thread=new Thread(()->{
//            try {
//                Thread.sleep(2000);
//                System.out.println("end");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//        WatchDog.getInstance().addMonitor(thread,t->{
//            System.out.println(t.getName());
//        });
//
//        TimeUnit.SECONDS.sleep(30);

        WatchDog.getInstance().start();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        WatchDog.getInstance().addMonitor(thread, t -> {
            t = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        });

        TimeUnit.SECONDS.sleep(30);
    }
}

package com.zte.sunquan.demo.t;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CapacityHandlerRegisterImpl class
 *
 * @author 10184538
 * @date 2019/4/26
 */
public class CapacityHandlerRegisterImpl extends AbstractHandlerRegister<CapacityHandler> {

    public void start() {
        CompletableFuture<Void> nodeLayer = CompletableFuture.runAsync(this::printA);
        nodeLayer.thenRunAsync(this::printB).join();
//        try {
            //nodeLayer.thenRunAsync(this::printB).get();
            //nodeLayer.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        CapacityHandlerRegisterImpl impl = new CapacityHandlerRegisterImpl();
        impl.start();
        Thread.sleep(1000);
    }

    private void printA() {
        System.out.println("AAAAAAAAAA");
    }

    public void printB() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BBBBBBBBBB");
    }
}

package com.zte.sunquan.demo.queue.main;

import com.zte.sunqun.demo.queue.BatchQueue;
import com.zte.sunqun.demo.queue.BatchQueueImpl;

import java.util.Scanner;

public class TestMain1 {
    public static void main(String[] args) {
        BatchQueue batchQueue = new BatchQueueImpl<>("string", 3, 10 * 1000, p -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result=" + p);
        });
        while (true) {
            String line = new Scanner(System.in).nextLine();
            if (line.equals("done")) {
                batchQueue.commit();
                break;
            }
            batchQueue.add(line);
        }
    }
}

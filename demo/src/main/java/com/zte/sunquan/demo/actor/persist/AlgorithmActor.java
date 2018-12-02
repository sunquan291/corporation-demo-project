package com.zte.sunquan.demo.actor.persist;

import akka.actor.Props;
import akka.persistence.AbstractPersistentActor;
import akka.persistence.RecoveryCompleted;
import akka.persistence.SnapshotOffer;

/**
 * Created by 10184538 on 2017/9/30.
 */
public class AlgorithmActor extends AbstractPersistentActor {
    private static final String PERSISTENCE_ID = "AlgorithmActor-1";
    private int result = 0;
    private String name;

    public AlgorithmActor() {
    }

    public AlgorithmActor(String name) {
        this.name = name;
    }

    public static Props props() {
        return Props.create(AlgorithmActor.class);
    }

    public static Props props(String name) {
        return Props.create(AlgorithmActor.class, name);
    }

    @Override
    public Receive createReceiveRecover() {
        return receiveBuilder().match(SnapshotOffer.class, p -> {
            result = (int) ((SnapshotOffer) p).snapshot();
            System.out.println("got snapshot:" + result);
        }).match(String.class, p -> {
            System.out.println("got recover msg and cal:" + p);
            calResult(p);
        }).match(RecoveryCompleted.class, p -> {
            System.out.println(getContext().self() + " has recovery complete.");
        })
                //必须
                .build();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, p -> {
            if ("snapshot".equalsIgnoreCase(p)) {
                saveSnapshot(result);
            } else if ("print".equalsIgnoreCase(p)) {
                System.out.println("result:" + result);
            } else {
                calResult(p);
                //save log
                persist(p, m -> {
                    //after persist
                    System.out.println("persist msg:" + p);
//                getContext().system().eventStream().publish(m);
                });
            }


        })
                .build();
    }

    @Override
    public String persistenceId() {
        return PERSISTENCE_ID;
    }

    private void calResult(String p) {
        int num = Integer.parseInt(p.substring(1));
        String symbol = p.substring(0, 1);
        switch (symbol) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                result /= num;
                break;
            default:

                break;
        }
    }
}

package com.zte.sunquan.demo.actor.cluster.example;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.zte.sunquan.demo.actor.cluster.simple.SimpleClusterListener;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Created by 10184538 on 2018/1/5.
 */
public class Node2 {
    private static ActorSystem system;
    private static String ip=Ip4AddressUtils.getLocalIp4Address();
    private static String seed= MessageFormat
            .format("akka.cluster.seed-nodes = [\"akka.tcp://ClusterSystem@{0}:2551\",\"akka.tcp://ClusterSystem@{1}:2552\",\"akka.tcp://ClusterSystem@{2}:2553\"]",
            "10.42.197.157"," 10.42.94.233",ip);
    public static void main(String[] args) {
        startup(new String[]{"2552"});
        // Cluster.get(system).leave(new Address("tcp","ClusterSystem","10.42.197.156",2551));

        new Scanner(System.in).next();
    }

    public static void startup(String[] ports) {
        for (String port : ports) {
            // Override the configuration of the port
            Config config = ConfigFactory.parseString(
                    "akka.remote.netty.tcp.port=" + port)
//                    .withFallback(ConfigFactory.parseString("akka.cluster.auto-down-unreachable-after=10s"))
                    .withFallback(ConfigFactory
                            .parseString("akka.actor.provider = akka.cluster.ClusterActorRefProvider"))
                    .withFallback(ConfigFactory.parseString(seed))
                    .withFallback(
                            ConfigFactory.load());

            // Create an Akka system
            system = ActorSystem.create("ClusterSystem", config);

            // Create an actor that handles cluster domain events
            system.actorOf(Props.create(SimpleClusterListener.class),
                    "clusterListener");

        }
    }
}

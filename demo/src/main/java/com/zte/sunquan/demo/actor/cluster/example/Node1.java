package com.zte.sunquan.demo.actor.cluster.example;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.cluster.Cluster;
import akka.cluster.ClusterReadView;
import akka.cluster.Member;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.zte.sunquan.demo.actor.cluster.simple.SimpleClusterListener;

import java.text.MessageFormat;
import java.util.Scanner;
import java.util.stream.Collectors;
import scala.collection.Iterator;
import scala.collection.immutable.SortedSet;

/**
 * Created by 10184538 on 2018/1/5.
 */
public class Node1 {
    private static ActorSystem system;
    private static String ip=Ip4AddressUtils.getLocalIp4Address();
    private static String seed=MessageFormat.format("akka.cluster.seed-nodes = [\"akka.tcp://ClusterSystem@{0}:2551\",\"akka.tcp://ClusterSystem@{1}:2552\",\"akka.tcp://ClusterSystem@{2}:2553\"]",ip,"10.42.94.122",ip);
    public static void main(String[] args) {
        startup(new String[]{"2551"});
        // Cluster.get(system).leave(new Address("tcp","ClusterSystem","10.42.197.156",2551));
        new Scanner(System.in).next();
    }

    public static void startup(String[] ports) {
        MessageFormat.format("akka.cluster.seed-nodes = [\"akka.tcp://ClusterSystem@{1}:2551\",\"akka.tcp://ClusterSystem@{2}:2552\",\"akka.tcp://ClusterSystem@{3}:2553\"]",ip,"10.42.94.122",ip);
        for (String port : ports) {
            // Override the configuration of the port
            Config config = ConfigFactory.parseString(
                    "akka.remote.netty.tcp.port=" + port)
//                    .withFallback(ConfigFactory.parseString("akka.cluster.auto-down-unreachable-after=10s"))
                    .withFallback(ConfigFactory.parseString("akka.actor.provider = akka.cluster.ClusterActorRefProvider"))
//                    .withFallback(ConfigFactory.parseString("akka.cluster.downing-provider-class = com.lightbend.akka.sbr.SplitBrainResolverProvider"))
//                    .withFallback(ConfigFactory.parseString("akka.cluster.split-brain-resolver.active-strategy = static-quorum"))
//                    .withFallback(ConfigFactory.parseString("akka.cluster.split-brain-resolver.static-quorum.quorum-size = 2"))
                    .withFallback(ConfigFactory.parseString(seed))
                    .withFallback(
                            ConfigFactory.load());

            // Create an Akka system
            system = ActorSystem.create("ClusterSystem", config);
            // Create an actor that handles cluster domain events
            system.actorOf(Props.create(SimpleClusterListener.class),
                    "clusterListener");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ClusterReadView clusterReadView = Cluster.get(system).readView();
                    SortedSet<Member> members = clusterReadView.members();
                    Iterator<Member> iterator = members.iterator();
                    while (iterator.hasNext()){
                        Member next = iterator.next();
                        System.out.println("abcd*************"+next.address());
                    }
                }}
            }).start();


        }
    }
}

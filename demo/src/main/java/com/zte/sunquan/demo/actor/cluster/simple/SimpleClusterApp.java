package com.zte.sunquan.demo.actor.cluster.simple;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class SimpleClusterApp {
    private static ActorSystem system;

    public static void main(String[] args) {
        if (args.length == 0)
            startup(new String[]{"2551", "2552", "0"});
        else
            startup(args);

        // Cluster.get(system).leave(new Address("tcp","ClusterSystem","10.42.197.156",2551));


    }

    public static void startup(String[] ports) {
        for (String port : ports) {
            // Override the configuration of the port
            Config config = ConfigFactory.parseString(
                    "akka.remote.netty.tcp.port=" + port)
                    .withFallback(ConfigFactory.parseString("akka.actor.provider = akka.cluster.ClusterActorRefProvider"))
                    .withFallback(ConfigFactory.parseString("akka.cluster.seed-nodes = [\"akka.tcp://ClusterSystem@10.42.197.156:2551\"]"))
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

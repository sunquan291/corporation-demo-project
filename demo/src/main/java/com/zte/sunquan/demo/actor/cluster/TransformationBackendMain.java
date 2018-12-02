package com.zte.sunquan.demo.actor.cluster;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class TransformationBackendMain {
    // Override the configuration of the port when specified as program argument
    public static void main(String[] args) {
        final String port = args.length > 0 ? args[0] : "0";
        final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port).
                withFallback(ConfigFactory.parseString("akka.cluster.roles = [backend]"))
                 .withFallback(ConfigFactory.parseString("akka.actor.provider = akka.cluster.ClusterActorRefProvider"))
                .withFallback(ConfigFactory.parseString("akka.cluster.seed-nodes = [\"akka.tcp://ClusterSystem@10.42.197.163:2551\"]")).
                withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("ClusterSystem", config);
        system.actorOf(Props.create(TransformationBackend.class), "backend");
    }
}

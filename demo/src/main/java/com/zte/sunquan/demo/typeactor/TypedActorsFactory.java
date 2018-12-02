package com.zte.sunquan.demo.typeactor;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.japi.Creator;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by 10184538 on 2018/1/2.
 */
public class TypedActorsFactory {
    ActorSystem system;

    Config config = ConfigFactory.parseString(
            "akka.remote.netty.tcp.port=" + 2552)
            .withFallback(ConfigFactory.parseString("akka.remote.transport = akka.remote.netty.NettyRemoteTransport"))
            .withFallback(ConfigFactory.parseString("akka.actor.provider = akka.remote.RemoteActorRefProvider"))
            .withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.hostname = 127.0.0.1"))
            .withFallback(ConfigFactory.parseString("akka.loglevel = INFO"))
            .withFallback(
                    ConfigFactory.load());

    TypedActorsFactory(String sysName) {
        this.system = ActorSystem.create(sysName, config);
    }


    Squarer getTypedActorDefault() {
        Squarer mySquarer =
                TypedActor.get(system).typedActorOf(
                        new TypedProps<SquarerImpl>(Squarer.class, SquarerImpl.class));
        //注意这里创建的是代理类型
        return mySquarer;
    }

    Squarer getTypedActor(String name) {
        long start=System.currentTimeMillis();
        System.out.println("Data:"+start);
        Squarer otherSquarer =
                TypedActor.get(system).typedActorOf(new TypedProps<SquarerImpl>(Squarer.class,
                                new Creator<SquarerImpl>() {
                                    public SquarerImpl create() {
                                        return new SquarerImpl(name);
                                    }  //这里创建的是具体的实现类型
                                }),
                        name);  //这个name是actor的name：akka//sys@host:port/user/name
        return otherSquarer;
    }
}

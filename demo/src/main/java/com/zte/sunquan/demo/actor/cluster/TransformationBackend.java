package com.zte.sunquan.demo.actor.cluster;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.Member;
import akka.cluster.protobuf.msg.ClusterMessages;

import static com.zte.sunquan.demo.actor.cluster.TransformationMessages.BACKEND_REGISTRATION;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class TransformationBackend extends AbstractActor {
    public static Props props() {
        return Props.create(TransformationBackend.class);
    }

    Cluster cluster = Cluster.get(getContext().system());

    //subscribe to cluster changes, MemberUp
    @Override
    public void preStart() {
        //接收所有cluster node的member up
        cluster.subscribe(getSelf(), ClusterEvent.MemberUp.class);
    }

    //re-subscribe when restart
    @Override
    public void postStop() {
        cluster.unsubscribe(getSelf());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TransformationMessages.TransformationJob.class, p -> {
                    getSender().tell(new TransformationMessages.TransformationResult(p.getText().toUpperCase())
                            , getSelf());
                })
                .match(ClusterEvent.CurrentClusterState.class, p -> {
                    System.out.println("CurrentClusterState:"+p);
                    for (Member member : p.getMembers()) {
                        if (member.status().equals(ClusterMessages.MemberStatus.Up)) {
                            register(member);
                        }
                    }
                })
                .match(ClusterEvent.MemberUp.class, p -> {
                    register(p.member());
                })
                .build();


    }

    private void register(Member member) {
        if (member.hasRole("frontend")) {
            System.out.println(member.address() + "/user/frontend");
            getContext().actorSelection(member.address() + "/user/frontend").tell(
                    BACKEND_REGISTRATION, getSelf());
        }

    }
}

package com.zte.sunquan.demo.actor.cluster.simple;

import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class SimpleClusterListener extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    Cluster cluster = Cluster.get(getContext().system());

    //subscribe to cluster changes
    @Override
    public void preStart() {
        cluster.subscribe(getSelf(),
                ClusterEvent.initialStateAsEvents(),
                ClusterEvent.MemberEvent.class,
                ClusterEvent.UnreachableMember.class,
                ClusterEvent.RoleLeaderChanged.class,
                ClusterEvent.LeaderChanged.class,
                ClusterEvent.MemberJoined.class
        );
    }

    //re-subscribe when restart
    @Override
    public void postStop() {
        cluster.unsubscribe(getSelf());
    }

    @Override
    public void onReceive(Object message) {

        if (message instanceof ClusterEvent.LeaderChanged) {
            ClusterEvent.LeaderChanged roleLeaderChanged =
                    (ClusterEvent.LeaderChanged) message;

            log.info("leader changed: {}", roleLeaderChanged);
        }

        if (message instanceof ClusterEvent.RoleLeaderChanged) {
            ClusterEvent.RoleLeaderChanged roleLeaderChanged = (ClusterEvent.RoleLeaderChanged) message;

            log.info("Role leader changed: {}", roleLeaderChanged);
        }
        if (message instanceof ClusterEvent.MemberJoined) {
            ClusterEvent.MemberJoined mUp = (ClusterEvent.MemberJoined) message;
            log.info("Member joined: {}", mUp);

        }

        if (message instanceof ClusterEvent.MemberUp) {
            ClusterEvent.MemberUp mUp = (ClusterEvent.MemberUp) message;
            log.info("Member is Up: {}", mUp.member());

        } else if (message instanceof ClusterEvent.UnreachableMember) {
            ClusterEvent.UnreachableMember mUnreachable = (ClusterEvent.UnreachableMember) message;
            log.info("Member detected as unreachable: {}", mUnreachable.member());

        } else if (message instanceof ClusterEvent.MemberRemoved) {
            ClusterEvent.MemberRemoved mRemoved = (ClusterEvent.MemberRemoved) message;
            log.info("Member is Removed: {}", mRemoved.member());

        } else if (message instanceof ClusterEvent.MemberEvent) {
            // ignore
        } else {
            unhandled(message);
        }

    }
}

package com.zte.sunquan.demo.actor.persist;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by 10184538 on 2017/9/30.
 * akka.persistence.journal.leveldb.dir = "target/example/journal"
 * akka.persistence.journal.plugin = "akka.persistence.journal.leveldb"
 * akka.persistence.snapshot-store.plugin = "akka.persistence.snapshot-store.local"
 * akka.persistence.snapshot-store.local.dir = "target/example/snapshots"
 */
public class ActorTest {
    private ActorSystem system;

    @Before
    public void init() throws IOException {
        system = ActorSystem.create("test-sq");
        //delete snapshot and journal
        String projectPath = System.getProperty("user.dir");
        File journalDir = new File(projectPath + File.separator + "target/example/journal");
        File snapshotDir = new File(projectPath + File.separator + "target/example/snapshots");
        FileUtils.cleanDirectory(journalDir);
        FileUtils.cleanDirectory(snapshotDir);
    }

    @Test
    public void testLocalPersistActor() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorRef calActor = system.actorOf(AlgorithmActor.props());
        calActor.tell("+1", ActorRef.noSender());
        calActor.tell("*2", ActorRef.noSender());
        calActor.tell("*5", ActorRef.noSender());
        calActor.tell("print", ActorRef.noSender());//print 10
        Thread.sleep(2000);
        system.stop(calActor);
        ActorRef calActor2 = system.actorOf(AlgorithmActor.props("alg"));
        calActor2.tell("*5", ActorRef.noSender());//first repeat +1 *2 *5 msg
        calActor2.tell("print", ActorRef.noSender());//print 50

        calActor2.tell("snapshot", ActorRef.noSender());
        calActor2.tell("/2", ActorRef.noSender());
        calActor2.tell("print", ActorRef.noSender());//print 25
        Thread.sleep(2000);
        system.stop(calActor2);

        calActor = system.actorOf(AlgorithmActor.props());
        calActor.tell("+1", ActorRef.noSender());// repeat only one /2 msg after get snapshot
        calActor.tell("print", ActorRef.noSender());//print 26
        latch.await();
    }
}

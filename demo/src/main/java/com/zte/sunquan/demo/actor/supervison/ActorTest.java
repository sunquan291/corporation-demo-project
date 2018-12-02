package com.zte.sunquan.demo.actor.supervison;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import com.zte.sunquan.demo.actor.persist.AlgorithmActor;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by 10184538 on 2017/10/31.
 */
public class ActorTest {
    private ActorSystem system;

    @Before
    public void init() throws IOException {
        system = ActorSystem.create("test-sq");
        //delete snapshot and journal
//        String projectPath = System.getProperty("user.dir");
//        File journalDir = new File(projectPath + File.separator + "target/example/journal");
//        File snapshotDir = new File(projectPath + File.separator + "target/example/snapshots");
//        FileUtils.cleanDirectory(journalDir);
//        FileUtils.cleanDirectory(snapshotDir);
    }

    @Test
    public void testActor() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorRef calActor = system.actorOf(Actor1.props(),"ABC");
        System.out.println("ABC:"+calActor.path());
        ActorSelection actorSelection = system.actorSelection("akka://test-sq/user/ABC");
        System.out.println("anchorPath:"+actorSelection.anchorPath());

        latch.await();
    }
}

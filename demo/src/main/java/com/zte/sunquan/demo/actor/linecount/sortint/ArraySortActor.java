package com.zte.sunquan.demo.actor.linecount.sortint;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.zte.sunquan.demo.Pair;

import java.util.Arrays;

/**
 * Created by 10184538 on 2017/6/17.
 */
public class ArraySortActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof int[]) {
            int[] inputs = (int[]) o;
            //排序
            Arrays.sort(inputs);
            getSender().tell(new Pair<Integer>(inputs[0], inputs[inputs.length - 1]), ActorRef.noSender());
        }
    }
}
package com.zte.sunquan.demo.actor.linecount.sortint;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.zte.sunquan.demo.Pair;

import java.util.Arrays;

/**
 * Created by 10184538 on 2017/6/17.
 */
public class MySortActor extends UntypedActor {
    public final static int divCount = 3;

    public int dataSize = 0;

    public int returnTimes = 0;

    public Pair resutPair = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof int[]) {
            //拆分数组，分别排序
            int[] inputs = (int[]) o;
            int i = 0;
            dataSize = inputs.length;
            for (i = 0; i < inputs.length / divCount; i++) {
                int[] data = Arrays.copyOfRange(inputs, i * divCount, (i + 1) * divCount);
                ActorRef arraySortActorRef = getContext().actorOf(Props.create(ArraySortActor.class));
                arraySortActorRef.tell(data, this.self());
            }
            if (i * divCount < inputs.length) {
                ActorRef arraySortActorRef = getContext().actorOf(Props.create(ArraySortActor.class));
                arraySortActorRef.tell(Arrays.copyOfRange(inputs, i * divCount, inputs.length),
                        this.self());
            }
        } else if (o instanceof Pair) {
            Pair pair = (Pair) o;
            System.out.println(pair.getMinValue() + "," + pair.getMaxValue());
            if (resutPair.getMinValue().compareTo(pair.getMinValue()) > 0) {
                resutPair.setMinValue(pair.getMinValue());
            }
            if (resutPair.getMaxValue().compareTo(pair.getMaxValue()) < 0) {
                resutPair.setMaxValue(pair.getMaxValue());
            }
            returnTimes++;
            int times = dataSize % divCount == 0 ? dataSize / divCount : dataSize / divCount + 1;
            if (times == returnTimes) {
                System.out.println("----------------------");
                System.out.println(resutPair.getMinValue() + "," + resutPair.getMaxValue());
//                getContext().system().shutdown();
            }
        }

    }
}

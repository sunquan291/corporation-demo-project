package com.zte.sunquan.demo.typeactor;

import akka.japi.Option;
import scala.concurrent.Future;

/**
 * Created by 10184538 on 2018/1/2.
 */

public interface Squarer {
    //fire-forget
    void squareDontCare(int i);

    //non-blocking send-request-reply
    Future<Integer> square(int i);

    //blocking send-request-reply
    Option<Integer> squareNowPlease(int i);

    //blocking send-request-reply
    int squareNow(int i);

    default String currentThreadName() {
        return Thread.currentThread().getName();
    }
}

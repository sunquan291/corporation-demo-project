package com.zte.sdn.oscp.topology.node.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.zte.sdn.oscp.topology.framework.core.handler.Handler;

/**
 * NodeHandler class
 *
 * @author 10184538
 * @date 2019/6/6
 */
public interface NodeHandler extends Handler {
    ExecutorService executorService = new ThreadPoolExecutor(64, 100,
            100L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>()/*, UserThreadFactory.build("discovery-link")*/);
    Node create(Node node);
}

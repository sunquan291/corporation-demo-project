package com.zte.sunquan.demo.thread.dump;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;


/**
 * Created by 10184538 on 2018/5/3.
 */
public class ThreadDump implements Callable<String> {

    public String call() throws Exception {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        StringBuffer b = new StringBuffer("Thread dump\n");
        ThreadInfo[] infos = threadMXBean.dumpAllThreads(threadMXBean.isObjectMonitorUsageSupported(), threadMXBean.isSynchronizerUsageSupported());
        for (int i = 0; i < infos.length; i++) {
            ThreadInfo ti = infos[i];
            b.append("\n\nThreadId: ").append(ti.getThreadId()).append(" : name: ").append(ti.getThreadName()).append(" State: ").append(ti.getThreadState());
            b.append("\n  LockInfo: ").append(ti.getLockInfo()).append(" LockOwnerId: ").append(ti.getLockOwnerId()).append(" LockOwnerName: ").append(ti.getLockOwnerName());
            StackTraceElement[] stackTrace = ti.getStackTrace();
            for (int j = 0; j < stackTrace.length; j++) {
                b.append("\n  ").append(stackTrace[j]);
            }
        }
        return b.toString();
    }

    public static void main(String[] args) throws Exception {
        String call = new ThreadDump().call();
        System.out.println(call);
    }
}
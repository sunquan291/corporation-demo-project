package com.zte.sunqun.demo.queue;

public interface BatchQueue<T> {
    boolean add(T t);

    /**
     * 查询一次批量提交数量
     *
     * @return
     */
    long getCommitSize();

    /**
     * 查询超时提交的时间
     *
     * @return
     */
    long getTimeOut();

    /**
     * 立即提交处理
     */
    void commit();

    long getQueueSize();
}

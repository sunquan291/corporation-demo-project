package com.zte.sunquan.baits;

/**
 * @Author: Livio
 * @Date: 2020/6/1 23:00
 *
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId,Class<T> cls, Object[] params) {
        String sql = Configuration.getSqlMapping().getString(statementId);
        return executor.query(sql,cls, params);
    }

    public <T> T getMapper(Class<T>  cls) {
        return configuration.getMapper(cls,this);
    }
}

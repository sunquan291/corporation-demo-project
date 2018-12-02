package org.apache.karaf.instance.core;

/**
 * Created by 10184538 on 2018/1/18.
 */
public abstract interface Instance
{
    public static final String STOPPED = "Stopped";
    public static final String STARTING = "Starting";
    public static final String STARTED = "Started";
    public static final String ERROR = "Error";

    public abstract String getName();

    @Deprecated
    public abstract void setName(String paramString);

    public abstract boolean isRoot();

    public abstract String getLocation();

    @Deprecated
    public abstract void setLocation(String paramString);

    public abstract int getPid();

    public abstract int getSshPort();

    public abstract void changeSshPort(int paramInt)
            throws Exception;

    public abstract int getRmiRegistryPort();

    public abstract void changeRmiRegistryPort(int paramInt)
            throws Exception;

    public abstract int getRmiServerPort();

    public abstract void changeRmiServerPort(int paramInt)
            throws Exception;

    public abstract String getJavaOpts();

    public abstract void changeJavaOpts(String paramString)
            throws Exception;

    public abstract void start(String paramString)
            throws Exception;

    public abstract void stop()
            throws Exception;

    public abstract void destroy()
            throws Exception;

    public abstract String getState()
            throws Exception;

    @Deprecated
    public abstract boolean isAttached();

    public abstract void changeSshHost(String paramString)
            throws Exception;
}
package org.apache.karaf.instance.core.internal;

/**
 * Created by 10184538 on 2018/1/18.
 */
import org.apache.karaf.instance.core.Instance;

public class InstanceImpl
        implements Instance
{
    private final InstanceServiceImpl service;
    private String name;

    public InstanceImpl(InstanceServiceImpl service, String name)
    {
        this.service = service;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        throw new UnsupportedOperationException();
    }

    void doSetName(String name) {
        this.name = name;
    }

    public boolean isRoot() {
        return this.service.isInstanceRoot(this.name);
    }

    public String getLocation() {
        return this.service.getInstanceLocation(this.name);
    }

    public void setLocation(String location) {
        throw new UnsupportedOperationException();
    }

    public int getPid() {
        return this.service.getInstancePid(this.name);
    }

    public int getSshPort() {
        return this.service.getInstanceSshPort(this.name);
    }

    public void changeSshPort(int port) throws Exception {
        this.service.changeInstanceSshPort(this.name, port);
    }

    public int getRmiRegistryPort() {
        return this.service.getInstanceRmiRegistryPort(this.name);
    }

    public void changeRmiRegistryPort(int port) throws Exception {
        this.service.changeInstanceRmiRegistryPort(this.name, port);
    }

    public int getRmiServerPort() {
        return this.service.getInstanceRmiServerPort(this.name);
    }

    public void changeRmiServerPort(int port) throws Exception {
        this.service.changeInstanceRmiServerPort(this.name, port);
    }

    public String getJavaOpts() {
        return this.service.getInstanceJavaOpts(this.name);
    }

    public void changeJavaOpts(String javaOpts) throws Exception {
        this.service.changeInstanceJavaOpts(this.name, javaOpts);
    }

    public void start(String javaOpts) throws Exception {
        this.service.startInstance(this.name, javaOpts);
    }

    public void stop() throws Exception {
        this.service.stopInstance(this.name);
    }

    public void destroy() throws Exception {
        this.service.destroyInstance(this.name);
    }

    public String getState() throws Exception {
        return this.service.getInstanceState(this.name);
    }

    public boolean isAttached() {
        return getPid() != 0;
    }

    public void changeSshHost(String host) throws Exception {
        this.service.changeInstanceSshHost(this.name, host);
    }
}
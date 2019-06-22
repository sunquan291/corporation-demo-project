package com.zte.sdn.oscp.topology.node.handler;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.zte.sdn.oscp.framework.service.ServiceProvider;
import com.zte.sdn.oscp.topology.framework.core.handler.AbstractHandlerRegister;

/**
 * Created by 10043533 on 2018/7/13
 */
@Component(immediate = true, service = NodeHandlerRegister.class)
public class NodeHandlerRegisterImpl extends AbstractHandlerRegister<NodeHandler> implements NodeHandlerRegister {

    public NodeHandlerRegisterImpl() {
        this(null);
    }

    public NodeHandlerRegisterImpl(ServiceProvider parent) {
        super(parent);
    }

    @Override
    @Activate
    protected void activate(BundleContext bundleContext) {
        super.activate(bundleContext);
    }

    @Override
    @Deactivate
    protected void deactivate() {
        super.deactivate();
    }
}

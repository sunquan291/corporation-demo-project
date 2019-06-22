package com.zte.sdn.oscp.topology.node.handler;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.zte.sdn.oscp.commons.log.Logger;
import com.zte.sdn.oscp.commons.log.LoggerFactory;
import com.zte.sdn.oscp.framework.service.MainServiceBase;
import com.zte.sdn.oscp.framework.service.ServiceProvider;
import com.zte.sdn.oscp.framework.service.annotations.Service;

/**
 * Created by 10043533 on 2018/7/13
 */
@Component(immediate = true, service = NodeQueryService.class)
public class NodeQueryServiceImpl extends MainServiceBase implements NodeQueryService {

    private static final Logger LOG = LoggerFactory.getLogger(NodeQueryServiceImpl.class);

    @Service
    private NodeHandlerRegister nodeHandlerRegister;

    public NodeQueryServiceImpl() {
        this(null);
    }

    public NodeQueryServiceImpl(ServiceProvider parent) {
        super(parent);
    }

    @Override
    public Node create(Node node) {
        System.out.println("NodeQueryServiceImpl" + node);
        node.setName("abc");
        return node;
    }


    @Override
    public void initialize() {
        super.initialize();
        nodeHandlerRegister.addHandler(this);
    }


    @Reference
    public void setNodeHandlerRegister(NodeHandlerRegister nodeHandlerRegister) {
        this.addReference(NodeHandlerRegister.class, nodeHandlerRegister);
    }

}


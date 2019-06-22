package com.zte.sdn.oscp.topology.node.handler;

import java.util.concurrent.Future;

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
@Component(immediate = true, service = NodeStoreService.class)
public class NodeStoreServiceImpl extends MainServiceBase implements NodeStoreService {

    private static final Logger LOG = LoggerFactory.getLogger(NodeStoreServiceImpl.class);

    @Service
    private NodeHandlerRegister nodeHandlerRegister;

    public NodeStoreServiceImpl() {
        this(null);
    }

    public NodeStoreServiceImpl(ServiceProvider parent) {
        super(parent);
    }

    @Override
    public Node create(Node node) {
        System.out.println("NodeStoreServiceImpl" + node);
        Future<?> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //node.setName("wangfei");
            //注意这行可能不打印，如果handler链很快就结束
            System.out.println("aaaaaaaaaa");
        });
        return node;
    }

    @Override
    public Integer getPriority() {
        return 10000;
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


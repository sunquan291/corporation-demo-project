package com.zte.sdn.oscp.topology.node.handler;

import com.zte.sdn.oscp.framework.service.MainServiceBase;
import com.zte.sdn.oscp.framework.service.annotations.Service;

/**
 * NodeHandlerServiceImpl class
 *
 * @author 10184538
 * @date 2019/6/7
 */
public class NodeHandlerServiceImpl extends MainServiceBase implements NodeHandleService {
    @Service
    private NodeHandlerRegister nodeHandlerRegister;

    @Override
    public Node create(Node node) {
        //return nodeHandlerRegister.create(node);
        return nodeHandlerRegister.foreach(handler -> handler.create(node));
    }
}

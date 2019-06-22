package com.zte.sdn.oscp.topology.node.handler;

import java.util.List;
import java.util.function.Function;

/**
 * NodeHandlerRegister class
 *
 * @author 10184538
 * @date 2019/6/7
 */
public interface NodeHandlerRegister {

    void addHandler(NodeHandler handler);

    List<NodeHandler> getHandlerList();

    default Node create(Node node) {
        Node node1 = node;
        List<NodeHandler> handlerList = this.getHandlerList();
        if (!handlerList.isEmpty()) {
            node1 = handlerList.get(0).create(node);
            for (int i = 1; i < handlerList.size(); i++) {
                node1 = handlerList.get(i).create(node1);
            }
        }
        return node1;
    }

    Node foreach(Function<NodeHandler,Node> function);

}

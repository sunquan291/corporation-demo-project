package com.zte.sdn.oscp.topology.node.handler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.zte.sdn.oscp.framework.service.annotations.InjectService;
import com.zte.sdn.oscp.framework.service.annotations.Service;
import com.zte.sdn.oscp.framework.test.ServiceTestBase;

/**
 * NodeHandlerTest class
 *
 * @author 10184538
 * @date 2019/6/7
 */
@InjectService(accessClassType = NodeStoreService.class, serviceClassType = NodeStoreServiceImpl.class)
@InjectService(accessClassType = NodeQueryService.class, serviceClassType = NodeQueryServiceImpl.class)
@InjectService(accessClassType = NodeHandlerRegister.class, serviceClassType = NodeHandlerRegisterImpl.class)
@InjectService(accessClassType = NodeHandleService.class, serviceClassType = NodeHandlerServiceImpl.class)
public class NodeHandlerTest extends ServiceTestBase {
    @Service
    private NodeHandleService nodeHandleService;

    @Test
    public void test() {
        Node node = new Node();
        node.setName("sunquan");
        Node node1 = nodeHandleService.create(node);
        System.out.println(node1);
        boolean terminated = NodeHandler.executorService.isTerminated();
        System.out.println(terminated);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        terminated = NodeHandler.executorService..isTerminated();
        System.out.println(terminated);
    }
    @Test
    public void testlamda(){
        Node node1 = new Node();
        node1.setName("sunquan");
        Node node2 = new Node();
        node2.setName("sunquan2");
        List<Node> nodes= Lists.newArrayList(node1,node2);
        Set<String> collect = nodes.stream().map(Node::getName).collect(Collectors.toSet());
        System.out.println(collect);
    }
}


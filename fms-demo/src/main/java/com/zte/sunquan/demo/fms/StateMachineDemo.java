package com.zte.sunquan.demo.fms;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

public class StateMachineDemo {
    // 1. 定义状态机事件
    enum FSMEvent {
        ToA, ToB, ToC, ToD
    }

    // 2. 定义状态机类
    @StateMachineParameters(stateType = String.class, eventType = FSMEvent.class, contextType = Integer.class)
    static class StateMachineSample extends AbstractUntypedStateMachine {
        protected void fromAToB(String from, String to, FSMEvent event, Integer context) {
            System.out.println("Current fsm state1:" + this.getCurrentState());
            System.out.println("Transition from '" + from + "' to '" + to + "' on event '" + event +
                    "' with context '" + context + "'.");
        }

        protected void ontoB(String from, String to, FSMEvent event, Integer context) {
            System.out.println("Current fsm state2:" + this.getCurrentState());
            System.out.println("Entry State \'" + to + "\'.");
        }
    }

    public static void main(String[] args) {
        // 3. 创建状态过渡流程
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(StateMachineSample.class);
        //从状态A通过ToB事件转变为状态B前触发fromAToB方法
        builder.externalTransition().from("A").to("B").on(FSMEvent.ToB).callMethod("fromAToB");
        builder.externalTransition().from("B").to("C").on(FSMEvent.ToC).callMethod("fromAToB");
        //状态机进入B前执行方法ontoB
        builder.onEntry("B").callMethod("ontoB");

        // 4. 使用状态机
        UntypedStateMachine fsm = builder.newStateMachine("A");
        fsm.fire(FSMEvent.ToB, 10);
        fsm.fire(FSMEvent.ToC);

        System.out.println("Current state is " + fsm.getCurrentState());
    }
}

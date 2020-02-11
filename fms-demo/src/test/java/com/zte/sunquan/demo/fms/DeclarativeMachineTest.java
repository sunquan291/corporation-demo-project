package com.zte.sunquan.demo.fms;

import org.junit.Test;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.StateMachineConfiguration;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

public class DeclarativeMachineTest {
    @Test
    public void testDeclarativeMachine(){
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(DeclarativeMachine.class);
        StateMachineConfiguration configuration=StateMachineConfiguration.create();
        UntypedStateMachine fsm = builder.newAnyStateMachine(MyState.A);
        fsm.start();
        fsm.fire(MyEvent.ATOB);
        fsm.fire(MyEvent.BTOC);
        fsm.fire(MyEvent.CTOD);
    }

}

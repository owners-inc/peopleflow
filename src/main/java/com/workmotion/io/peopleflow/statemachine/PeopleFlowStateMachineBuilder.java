package com.workmotion.io.peopleflow.statemachine;

import com.workmotion.io.peopleflow.model.enums.Events;
import com.workmotion.io.peopleflow.model.enums.States;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

public class PeopleFlowStateMachineBuilder {

    public StateMachine<States, Events> buildMachine() throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        builder.configureStates()
                .withStates()
                .initial(States.ADDED)
                .states(EnumSet.allOf(States.class));

        builder.configureTransitions()
                .withExternal()
                .source(States.ADDED).target(States.IN_CHECK)
                .event(Events.CHECK)
                .and()
                .withExternal()
                .source(States.IN_CHECK).target(States.APPROVED)
                .event(Events.APPROVE)
                .and()
                .withExternal()
                .source(States.APPROVED).target(States.ACTIVE)
                .event(Events.APPROVE);

        return builder.build();
    }

    public void buildState() throws Exception {
        StateMachine<States, Events> stateMachine = buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(Events.APPROVE);
    }
}

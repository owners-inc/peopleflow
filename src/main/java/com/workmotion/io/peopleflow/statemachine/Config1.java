package com.workmotion.io.peopleflow.statemachine;

import com.workmotion.io.peopleflow.model.enums.Events;
import com.workmotion.io.peopleflow.model.enums.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
class Config1 extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.ADDED)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
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
    }
}

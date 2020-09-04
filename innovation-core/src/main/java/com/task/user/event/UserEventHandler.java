package com.task.user.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    @EventListener
    public void handleEvent(UserEvent userEvent) throws Exception{
        System.out.println(userEvent.aggregateId());
        System.out.println(userEvent.eventId());
        System.out.println(userEvent.eventName());
    }

}

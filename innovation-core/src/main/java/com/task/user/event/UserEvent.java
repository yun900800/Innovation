package com.task.user.event;

import com.task.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class UserEvent extends DomainEvent {

    public UserEvent(String id) {
        super(id);
    }


    @Override
    public String eventName() {
        return "UserEvent";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}

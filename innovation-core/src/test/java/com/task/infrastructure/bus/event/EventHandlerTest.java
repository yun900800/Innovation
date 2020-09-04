package com.task.infrastructure.bus.event;

import com.task.InnovationCoreTest;
import com.task.domain.bus.event.DomainEvent;
import com.task.domain.bus.event.EventBus;
import com.task.user.event.UserEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EventHandlerTest extends InnovationCoreTest {

    @Autowired
    private EventBus eventBus;

    @Test
    public void testSpringEventSend() {
        List<DomainEvent> userEvents = new ArrayList<>();
        userEvents.add(new UserEvent("aaaa"));
        eventBus.publish(userEvents);
    }


}

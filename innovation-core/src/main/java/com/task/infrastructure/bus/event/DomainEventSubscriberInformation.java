package com.task.infrastructure.bus.event;

import com.task.domain.Utils;
import com.task.domain.bus.event.DomainEvent;

import java.util.List;

public class DomainEventSubscriberInformation {

    /**
     * 订阅者类
     */
    private final Class<?>                           subscriberClass;
    /**
     * 订阅者类能够处理的事件集合
     */
    private final List<Class<? extends DomainEvent>> subscribedEvents;

    public DomainEventSubscriberInformation(
            Class<?> subscriberClass,
            List<Class<? extends DomainEvent>> subscribedEvents
    ) {
        this.subscriberClass  = subscriberClass;
        this.subscribedEvents = subscribedEvents;
    }

    public Class<?> subscriberClass() {
        return subscriberClass;
    }

    public String contextName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[2];
    }

    public String moduleName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[3];
    }

    public String className() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[nameParts.length - 1];
    }

    public List<Class<? extends DomainEvent>> subscribedEvents() {
        return subscribedEvents;
    }

    public String formatRabbitMqQueueName() {
        return String.format("codelytv.%s.%s.%s", contextName(), moduleName(), Utils.toSnake(className()));
    }
}

package com.task.domain.bus.command;

public interface CommandBus {

    void dispatch(Command command);

}

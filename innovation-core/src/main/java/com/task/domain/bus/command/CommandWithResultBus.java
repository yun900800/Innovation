package com.task.domain.bus.command;

public interface CommandWithResultBus {

    <R> R dispatchWithResult(Command command);

}

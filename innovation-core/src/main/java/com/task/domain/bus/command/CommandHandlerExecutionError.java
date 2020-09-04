package com.task.domain.bus.command;

public class CommandHandlerExecutionError extends RuntimeException{

    public CommandHandlerExecutionError(Throwable cause) {
        super(cause);
    }
}

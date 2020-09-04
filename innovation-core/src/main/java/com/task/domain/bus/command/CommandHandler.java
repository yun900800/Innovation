package com.task.domain.bus.command;

import com.task.domain.bus.query.Response;

public interface CommandHandler<T extends Command> {

    void handle(T command) throws CommandHandlerExecutionError;

}

package com.task.domain.bus.command;

import com.task.domain.bus.query.Response;

public interface CommandWithResultHandler<T extends Command, R extends Response> {

    R handleWithResult(T command) throws CommandHandlerExecutionError;

}

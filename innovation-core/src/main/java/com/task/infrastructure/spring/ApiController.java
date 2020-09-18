package com.task.infrastructure.spring;

import com.task.domain.DomainError;
import com.task.domain.bus.command.Command;
import com.task.domain.bus.command.CommandBus;
import com.task.domain.bus.command.CommandHandlerExecutionError;
import com.task.domain.bus.query.Query;
import com.task.domain.bus.query.QueryBus;
import com.task.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class ApiController {

    private final QueryBus queryBus;

    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus,
                         CommandBus commandBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}

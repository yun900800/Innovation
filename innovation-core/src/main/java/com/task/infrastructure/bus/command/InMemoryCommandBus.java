package com.task.infrastructure.bus.command;

import com.task.domain.bus.command.*;
import com.task.domain.bus.query.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCommandBus implements CommandBus , CommandWithResultBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }

    @Override
    public Response dispatchWithResult(Command command) {
        try {
            Class<? extends CommandWithResultHandler> commandHandlerClass = information.searchOne(command.getClass());

            CommandWithResultHandler handler = context.getBean(commandHandlerClass);

            return handler.handleWithResult(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}

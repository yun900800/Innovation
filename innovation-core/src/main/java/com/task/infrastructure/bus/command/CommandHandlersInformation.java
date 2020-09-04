package com.task.infrastructure.bus.command;

import com.task.domain.bus.command.Command;
import com.task.domain.bus.command.CommandHandler;
import com.task.domain.bus.command.CommandNotRegisteredError;
import com.task.domain.bus.command.CommandWithResultHandler;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Service
public class CommandHandlersInformation {
    HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    HashMap<Class<? extends Command>, Class<? extends CommandWithResultHandler>> indexedCommandWithResultHandlers;

    public CommandHandlersInformation() {
        Reflections reflections = new Reflections("com.task");
        Set<Class<? extends CommandHandler>> classes     = reflections.getSubTypesOf(CommandHandler.class);
        Set<Class<? extends CommandWithResultHandler>> classesOne     = reflections.getSubTypesOf(CommandWithResultHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
        indexedCommandWithResultHandlers = formatOneHandlers(classesOne);
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    public Class<? extends CommandWithResultHandler> searchOne(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandWithResultHandler> commandHandlerClass = indexedCommandWithResultHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(
            Set<Class<? extends CommandHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<>();

        for (Class<? extends CommandHandler> handler : commandHandlers) {
            ParameterizedType paramType    = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandWithResultHandler>> formatOneHandlers(
            Set<Class<? extends CommandWithResultHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandWithResultHandler>> handlers = new HashMap<>();

        for (Class<? extends CommandWithResultHandler> handler : commandHandlers) {
            ParameterizedType paramType    = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}

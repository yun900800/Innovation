package com.task.domain.bus.command;

public class CommandNotRegisteredError extends RuntimeException{

    public CommandNotRegisteredError(Class<? extends Command> command) {
        super(String.format("The command <%s> hasn't a command handler associated", command.toString()));
    }
}

package com.task.infrastructure.bus.command;

import com.task.InnovationCoreTest;
import com.task.domain.bus.command.CommandBus;
import com.task.domain.bus.command.CommandHandler;
import com.task.domain.bus.command.CommandWithResultBus;
import com.task.domain.bus.query.Response;
import com.task.user.command.UserCreateCommand;
import com.task.user.command.UserCreateCommandHanlder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandHandlersInformationTest extends InnovationCoreTest {

    @Autowired
    private CommandHandlersInformation commandHandlersInformation;

    @Autowired
    private CommandBus commandBus;

    @Autowired
    private CommandWithResultBus commandWithResultBus;

    @Test
    public void testSearch(){
        Class<CommandHandler> clzz = (Class<CommandHandler>)commandHandlersInformation.search(UserCreateCommand.class);
        Assert.assertEquals(clzz, UserCreateCommandHanlder.class);
    }

    @Test
    public void testCommandDispatch() {
        commandBus.dispatch(new UserCreateCommand());
    }

    @Test
    public void testCommandWithDispatch() {
        Response response = commandWithResultBus.dispatchWithResult(new UserCreateCommand());
        Assert.assertEquals(response.toString(),"自定义一个返回值");
    }
}

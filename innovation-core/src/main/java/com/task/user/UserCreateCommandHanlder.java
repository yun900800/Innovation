package com.task.user;

import com.task.domain.bus.command.CommandHandler;
import com.task.domain.bus.command.CommandHandlerExecutionError;
import org.springframework.stereotype.Service;

@Service
public class UserCreateCommandHanlder implements CommandHandler<UserCreateCommand> {
    @Override
    public void handle(UserCreateCommand command) throws CommandHandlerExecutionError {
        System.out.println("处理命令结束，没有返回值");
    }

}

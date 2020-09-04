package com.task.user.command;

import com.task.domain.bus.command.CommandHandlerExecutionError;
import com.task.domain.bus.command.CommandWithResultHandler;
import com.task.domain.bus.query.Response;
import org.springframework.stereotype.Service;

@Service
public class UserCreateCommandWithResultHanlder implements CommandWithResultHandler<UserCreateCommand, Response> {
    @Override
    public Response handleWithResult(UserCreateCommand command) throws CommandHandlerExecutionError {

        System.out.println("处理命令结束，有返回值");
        return new Response() {
            @Override
            public String toString() {
                return "自定义一个返回值";
            }
        };
    }
}

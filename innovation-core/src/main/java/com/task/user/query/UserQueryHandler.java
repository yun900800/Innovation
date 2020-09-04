package com.task.user.query;

import com.task.domain.bus.query.QueryHandler;
import com.task.domain.bus.query.Response;
import org.springframework.stereotype.Service;

@Service
public class UserQueryHandler implements QueryHandler<UserQuery, Response> {
    @Override
    public Response handle(UserQuery query) {
        System.out.println("执行查询处理器，然后返回值");
        return new Response() {
            @Override
            public String toString() {
                return "response";
            }
        };
    }
}

package com.task.infrastructure.bus.query;

import com.task.InnovationCoreTest;
import com.task.domain.bus.command.CommandBus;
import com.task.domain.bus.query.QueryBus;
import com.task.domain.bus.query.Response;
import com.task.user.command.UserCreateCommand;
import com.task.user.query.UserQuery;
import com.task.user.query.UserQueryHandler;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryHandlerTest extends InnovationCoreTest {

    @Autowired
    private QueryHandlersInformation queryHandlersInformation;

    @Autowired
    private QueryBus queryBus;

    @Test
    public void testSearch(){
        Class<UserQueryHandler> clzz = (Class<UserQueryHandler>)queryHandlersInformation.search(UserQuery.class);
        Assert.assertEquals(clzz, UserQueryHandler.class);
    }

    @Test
    public void testAskQuery() {
        Response e = queryBus.ask(new UserQuery());
        Assert.assertEquals(e.toString(), "response");
    }
}

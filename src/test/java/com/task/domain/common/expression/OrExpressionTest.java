package com.task.domain.common.expression;

import org.junit.Assert;
import org.junit.Test;

public class OrExpressionTest {

    @Test
    public void testOrExpression() {
        Expression expression = createExpression("aaa","aaa1");
        Expression expression1 = createExpression("aaa","aaa");
        AndExpression andExpression = new AndExpression(expression,expression1);
        Assert.assertEquals(andExpression.interpret(), false);

        OrExpression orExpression = new OrExpression(expression,expression1);
        Assert.assertEquals(orExpression.interpret(), true);
    }

    public static Expression createExpression(String userName, String newUserName) {
        Expression expression = new Expression() {
            @Override
            boolean interpret() {
                if (userName.equals(newUserName)) {
                    return true;
                }
                return false;
            }

            @Override
            public String toString() {
                return userName+"-"+newUserName;
            }
        };
        return expression;
    }

}

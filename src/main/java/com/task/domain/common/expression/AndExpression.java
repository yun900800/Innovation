package com.task.domain.common.expression;

public class AndExpression extends Expression{

    private Expression leftExpression;

    private Expression rightExpression;

    public AndExpression(Expression leftExpression,
                         Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    boolean interpret() {
        return leftExpression.interpret()&& rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "&";
    }
}

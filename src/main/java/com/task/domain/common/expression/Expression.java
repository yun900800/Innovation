package com.task.domain.common.expression;

public abstract class Expression {

    abstract boolean interpret();

    @Override
    public abstract String toString();
}

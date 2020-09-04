package com.task.domain.user.entity;

import com.task.domain.common.BaseEntity;

public class User extends BaseEntity {

    private String name;

    public User(String name){
        this(name, -1L);
    }

    public User(String name, Long id){
        super(id,id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

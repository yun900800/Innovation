package com.task.domain.task.entity;

import com.task.domain.common.BaseEntity;


public class Task extends BaseEntity {

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务价值
     */
    private final String taskValue;

    /**
     * 任务被引用次数
     */
    private Integer referenceCount;

    public Task(String name, String taskValue, String description, Long createUid) {
        super(createUid);
        this.name = name;
        this.taskValue = taskValue;
        this.description = description;
        this.referenceCount = 0;
    }

    public Task(String name, String taskValue,Long createUid) {
        this(name,taskValue,taskValue,createUid);
    }

    public Task incrementReferenceCount(){
        this.referenceCount++;
        return this;
    }

    /**
     * 修改任务描述
     * @param description
     */
    public Task modifyDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 修改任务名称
     * @param name
     * @return
     */
    public Task modifyName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskValue() {
        return taskValue;
    }

    @Override
    public String toString() {
        String baseStr = super.toString();
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", taskValue='" + taskValue + '\'' +
                '}'+" baseStr:"+baseStr;
    }
}

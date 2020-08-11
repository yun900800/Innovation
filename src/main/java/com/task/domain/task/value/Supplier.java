package com.task.domain.task.value;

import java.util.Date;

public class Supplier extends Collaborator{

    /**
     * 支撑者任务完成时间
     */
    private Date taskFinishTime;

    /**
     * 支撑者任务发布时间
     */
    private Date taskPublishTime;

    public Supplier(Long taskId, String taskDesc,
                    Long userId, String userName,
                    Date taskFinishTime) {
        super(taskId, taskDesc, userId, userName);
        this.taskFinishTime = taskFinishTime;
        this.taskPublishTime = taskFinishTime;
    }

    public Supplier modifyTaskPublishTime() {
        this.taskPublishTime = new Date();
        return this;
    }

    public Date getTaskFinishTime() {
        return taskFinishTime;
    }

    public Date getTaskPublishTime() {
        return taskPublishTime;
    }
}

package com.task.domain.task.value;

import java.util.Date;

public class Partner extends Collaborator {

    /**
     * 合作者任务开始时间
     */
    private Date startTime;

    /**
     * 合作者任务花费时间
     */
    private Long costTime;

    /**
     * 合作者任务发布时间
     */
    private Date taskPublishTime;

    public Partner(Long taskId, String taskDesc,
                   Long userId, String userName,
                   Date startTime, Long costTime) {
        super(taskId, taskDesc, userId, userName);
        this.startTime = startTime;
        this.costTime = costTime;
        this.taskPublishTime = new Date();
    }

    public Partner(Long taskId, String taskDesc,
                   Long userId, String userName) {
        super(taskId, taskDesc, userId, userName);
        this.startTime = new Date();
        this.costTime = 60*60*60*8L;
        this.taskPublishTime = new Date();
    }

    public Date getStartTime() {
        return startTime;
    }

    public Partner modifyTaskPublishTime() {
        this.taskPublishTime = new Date();
        return this;
    }

    public Long getCostTime() {
        return costTime;
    }
}

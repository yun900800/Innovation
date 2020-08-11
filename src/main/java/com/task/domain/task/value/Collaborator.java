package com.task.domain.task.value;

public class Collaborator {

    /**
     * 任务id
     */
    private final Long taskId;

    /**
     * 任务描述
     */
    private final String taskDesc;

    /**
     * 用户id
     */
    private final Long userId;

    /**
     * 用户名称
     */
    private final String userName;

    public Collaborator(Long taskId, String taskDesc, Long userId, String userName) {
        this.taskId = taskId;
        this.taskDesc = taskDesc;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "taskId=" + taskId +
                ", taskDesc='" + taskDesc + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}

package com.task.domain.task.value;

/**
 * 任务的活动
 */
public class Activity {

    /**
     * 活动描述
     */
    private String description;

    /**
     * 活动类型（产品优化，解决客户问题，基础类型，平台或者网络）
     */
    private Integer activityType;


    public Activity(String description, Integer activityType) {
        this.description =description;
        this.activityType = activityType;
    }

    public String getDescription() {
        return description;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public Activity modifyDescription(String description) {
        this.description = description;
        return this;
    }

    public Activity modifyActivityType(Integer activityType) {
        this.activityType = activityType;
        return this;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "description='" + description + '\'' +
                ", activityType=" + activityType +
                '}';
    }
}

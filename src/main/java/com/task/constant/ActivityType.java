package com.task.constant;

public enum ActivityType {

    BASE_TYPE(0),
    PRODUCT_IMPROVEMENT(1),
    RESOLVE_PROBLEM(2),
    NET_PLATFOTMS(3);

    private Integer type;

    ActivityType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}

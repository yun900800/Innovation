package com.task.domain.task.value;

import com.task.constant.ActivityType;

public class KeyActivity extends Activity{

    /**
     * 活动价值
     */
    private Integer value;

    public KeyActivity(String description, Integer value) {
        super(description, ActivityType.BASE_TYPE.getType());
        this.value = value;
    }

    public KeyActivity(String description, Integer value,ActivityType activityType){
        super(description, activityType.getType());
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    /**
     * 修改关键活动的价值
     * @param value
     * @return
     */
    public KeyActivity modifyValue(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * 重置关键活动的价值，默认为5
     * @return
     */
    public KeyActivity resetValue() {
        this.value = 5;
        return this;
    }

    @Override
    public String toString() {
        return "KeyActivity{" +
                "value=" + value +
                '}';
    }
}

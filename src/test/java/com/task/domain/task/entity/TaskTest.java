package com.task.domain.task.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TaskTest {

    @Test
    public void testTaskCreate() {
        Task task = new Task("test","验证测试的过程",101L);
        Assert.assertEquals(task.getCreatUid().longValue(),101L);
        Assert.assertEquals(task.getDescription(),"验证测试的过程");
        Assert.assertEquals(task.getName(),"test");
        Assert.assertEquals(task.getCreatUid(),task.getUpdateUid());
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e){

        }
        task.modifyName("test1").modifyDescription("验证测试的过程修改").modifyUpdateTime();
        Assert.assertNotEquals(task.getDescription(),"验证测试的过程");
        Assert.assertNotEquals(task.getName(),"test");
        Assert.assertNotEquals(task.getCreateTime(),task.getUpdateTime());
    }
}

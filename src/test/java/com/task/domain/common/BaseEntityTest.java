package com.task.domain.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class BaseEntityTest {

    @Test
    public void testCreateBaseEntity() {
        BaseEntity baseEntity = new BaseEntity(101L);
        Assert.assertEquals(baseEntity.getUpdateUid().longValue(),101L);
        Assert.assertEquals(baseEntity.getCreatUid().longValue(),101L);
    }

    @Test
    public void testUpdateUpdateUid() {
        BaseEntity baseEntity = new BaseEntity(101L);
        baseEntity.modifyUpdateUid(102L);
        Assert.assertEquals(baseEntity.getUpdateUid().longValue(),102L);
        Assert.assertEquals(baseEntity.getCreatUid().longValue(),101L);
    }

    @Test
    public void testUpdateUpdateTime(){
        BaseEntity baseEntity = new BaseEntity(101L);
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e){

        }
        baseEntity.modifyUpdateTime();
        Assert.assertNotEquals(baseEntity.getCreateTime(), baseEntity.getUpdateTime());
    }

}

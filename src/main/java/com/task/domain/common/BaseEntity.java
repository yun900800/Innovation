package com.task.domain.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 */
public class BaseEntity implements Serializable {

    private Long id;

    private Long creatUid;

    private Long updateUid;

    private Date createTime;

    private Date updateTime;

    public BaseEntity(Long id, Long createUid) {
        this.id = id;
        this.creatUid = createUid;
        this.updateUid = createUid;
        Date currentDate = new Date();
        this.createTime = currentDate;
        this.updateTime = currentDate;
    }

    public BaseEntity(Long createUid){
        this(0L,createUid);
    }

    public BaseEntity modifyUpdateTime() {
        this.updateTime = new Date();
        return this;
    }

    public BaseEntity modifyUpdateUid(Long updateUid) {
        this.updateUid = updateUid;
        return this;
    }


    public Long getId() {
        return id;
    }

    public Long getCreatUid() {
        return creatUid;
    }

    public Long getUpdateUid() {
        return updateUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", creatUid=" + creatUid +
                ", updateUid=" + updateUid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

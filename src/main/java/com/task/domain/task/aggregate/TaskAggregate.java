package com.task.domain.task.aggregate;

import com.task.domain.task.entity.Task;
import com.task.domain.task.value.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskAggregate {

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 任务信息
     */
    private Task task;

    /**
     * 任务需要的资源
     */
    private List<Resources> resourcesList = new ArrayList<>();

    /**
     * 任务的关键活动
     */
    private List<KeyActivity> keyActivities = new ArrayList<>();

    /**
     * 任务的参与者
     */
    private List<Partner> partners = new ArrayList<>();

    /**
     * 任务的支持者
     */
    private List<Supplier> suppliers = new ArrayList<>();

    public TaskAggregate(String name, String taskValue,Long createUid) {
        this.task = new Task(name,taskValue,taskValue,createUid);
        this.taskId = 0L;
    }

    public TaskAggregate(String name, String taskValue,Long createUid, Long taskId) {
        this.task = new Task(name,taskValue,taskValue,createUid);
        this.taskId = taskId;
    }

    /**
     * 添加任务需要的资源信息
     * @param resource
     * @return
     */
    public TaskAggregate addResource(Resources resource) {
        resourcesList.add(resource);
        return this;
    }

    /**
     * 添加任务需要的资源信息
     * @param resources
     * @return
     */
    public TaskAggregate addResources(List<Resources> resources) {
        resourcesList.addAll(resources);
        return this;
    }

    /**
     * 添加任务需要的资源信息
     * @param name
     * @param description
     * @param value
     * @return
     */
    public TaskAggregate addResource(String name, String description, Integer value){
        resourcesList.add(new Resources(name,description,value));
        return this;
    }

    /**
     * 移除资源
     * @param resources
     * @return
     */
    public TaskAggregate removeResource(Resources resources) {
        resourcesList.remove(resources);
        return this;
    }

    /**
     * 移除资源
     * @param resources
     * @return
     */
    public TaskAggregate removeResources(List<Resources> resources){
        for(Resources resource: resources) {
            resourcesList.remove(resource);
        }
        return this;
    }

    /**
     * 移除资源
     * @param name
     * @return
     */
    public TaskAggregate removeResource(String name){
        resourcesList = resourcesList.stream().filter(v->!v.getName().equals(name))
                .collect(Collectors.toList());
        return this;
    }

    /**
     * 修改资源对象
     * @param name
     * @param newName
     * @param description
     * @param value
     * @return
     */
    public TaskAggregate modifyRescouces(String name, String newName, String description, Integer value) {
        resourcesList = resourcesList.stream().map(v->{
            String curName = v.getName();
            if (name.equals(curName)) {
                Resources resources = new Resources(newName,description,value);
                return resources;
            }
            return v;
        }).collect(Collectors.toList());
        return this;
    }

}

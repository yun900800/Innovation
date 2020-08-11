package com.task.domain.task.value;

import java.util.Objects;

public class Resources {

    private String name;

    private String description;

    private Integer value;

    public Resources(String name, String description, Integer value){
        this.name = name;
        this.description = description;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return name.equals(resources.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getValue() {
        return value;
    }
}

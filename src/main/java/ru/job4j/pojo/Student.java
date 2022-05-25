package ru.job4j.pojo;

import java.time.LocalDateTime;

public class Student {
    private String name;
    private int group;
    private final LocalDateTime data = LocalDateTime.now();

    public LocalDateTime getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

}

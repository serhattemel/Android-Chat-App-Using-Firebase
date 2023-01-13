package com.example.a201913709048;

public class GroupModel {
    String name;
    String desc;

    public GroupModel()
    {
    }

    public GroupModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

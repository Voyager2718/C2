package com.zhipengyang.bunnyc2.data.skills;

public class Skill implements ISkill {
    protected String description;

    public Skill(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void release() {
    }
}

package com.zhipengyang.bunnyc2.data.skills;

import com.zhipengyang.bunnyc2.data.GameEvent;

public class Skill implements ISkill {
    protected String description;

    public void onEventArrived(GameEvent gameEvent) {
        gameEvent.visit(this);
    }

    public Skill(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void release() {
    }
}

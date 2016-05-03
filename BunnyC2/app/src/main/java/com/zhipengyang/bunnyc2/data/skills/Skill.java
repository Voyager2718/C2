package com.zhipengyang.bunnyc2.data.skills;

import com.zhipengyang.bunnyc2.data.GameAction;

public class Skill implements ISkill {
    protected String description;

    public void onEventArrived(GameAction gameAction) {
        gameAction.visit(this);
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

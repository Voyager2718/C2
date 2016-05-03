package com.zhipengyang.bunnyc2.data.skills;

import com.zhipengyang.bunnyc2.data.GameAction;

public class FrozenSkill extends SkillDecorator {
    public FrozenSkill(ISkill decoratedSkill) {
        super(decoratedSkill);
    }

    public void onEventArrived(GameAction gameAction) {
        gameAction.visit(this);
    }

    public void release() {

    }
}

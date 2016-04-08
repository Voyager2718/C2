package com.zhipengyang.bunnyc2.data.skills;

public class FrozenSkill extends SkillDecorator {
    public FrozenSkill(ISkill decoratedSkill) {
        super(decoratedSkill);
    }

    public void release() {

    }
}

package com.zhipengyang.bunnyc2.data;

import com.zhipengyang.bunnyc2.data.characters.C2;
import com.zhipengyang.bunnyc2.data.skills.FrozenSkill;
import com.zhipengyang.bunnyc2.data.skills.Skill;

/**
 * This is a visitor pattern.
 * In order to run specifics functions while reaching a certain time or event, I use visitor pattern to visit each class.
 */
public interface GameAction {
    void visit(TestListener testListener);

    void visit(C2 c2);

    void visit(Skill skill);

    void visit(FrozenSkill frozenSkill);
}

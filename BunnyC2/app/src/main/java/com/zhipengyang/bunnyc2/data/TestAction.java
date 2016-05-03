package com.zhipengyang.bunnyc2.data;


import android.util.Log;

import com.zhipengyang.bunnyc2.data.characters.C2;
import com.zhipengyang.bunnyc2.data.skills.FrozenSkill;
import com.zhipengyang.bunnyc2.data.skills.Skill;

public class TestAction implements GameAction {
    public void visit(TestListener testListener) {
        Log.d("_________EVENT_________", String.valueOf(testListener.testCount++));
    }

    public void visit(C2 c2) {
    }

    public void visit(Skill skill) {
    }

    public void visit(FrozenSkill frozenSkill) {
    }
}

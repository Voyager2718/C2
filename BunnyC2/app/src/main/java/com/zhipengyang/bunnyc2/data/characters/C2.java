package com.zhipengyang.bunnyc2.data.characters;

import com.zhipengyang.bunnyc2.data.GameAction;

public class C2 extends ACharacter {
    public void onEventArrived(GameAction gameAction) {
        gameAction.visit(this);
    }
}
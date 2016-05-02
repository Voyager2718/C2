package com.zhipengyang.bunnyc2.data.characters;

import com.zhipengyang.bunnyc2.data.GameEvent;

public class C2 extends ACharacter {
    public void onEventArrived(GameEvent gameEvent) {
        gameEvent.visit(this);
    }
}
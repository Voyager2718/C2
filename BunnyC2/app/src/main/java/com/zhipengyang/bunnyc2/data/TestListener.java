package com.zhipengyang.bunnyc2.data;

public class TestListener implements EventListener {
    public int testCount = 0;

    public void onEventArrived(GameAction gameAction) {
        gameAction.visit(this);
    }
}

package com.zhipengyang.bunnyc2.data;


import android.util.Log;

public class TestAction implements GameAction {
    public void visit(TestListener testListener) {
        Log.d("_________EVENT_________", String.valueOf(testListener.testCount++));
    }
}

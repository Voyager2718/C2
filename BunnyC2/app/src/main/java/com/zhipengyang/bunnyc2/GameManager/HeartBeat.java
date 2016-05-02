package com.zhipengyang.bunnyc2.GameManager;

import com.zhipengyang.bunnyc2.data.EventListener;

import java.util.Stack;

public final class HeartBeat {
    private static volatile HeartBeat INSTANCE = null;

    private Stack<EventListener> eventListeners;

    private HeartBeat() {
        eventListeners = new Stack<EventListener>();
    }

    /**
     * Getter of a singleton.
     *
     * @return An instance of HeartBeat
     */
    public HeartBeat getInstance() {
        if (INSTANCE == null) {
            synchronized (HeartBeat.class) {
                if (INSTANCE == null)
                    INSTANCE = new HeartBeat();
            }
        }
        return INSTANCE;
    }


}

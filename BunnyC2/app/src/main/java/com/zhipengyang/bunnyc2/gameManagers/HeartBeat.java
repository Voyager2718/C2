package com.zhipengyang.bunnyc2.gameManagers;

import com.zhipengyang.bunnyc2.data.EventListener;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class HeartBeat {
    private static volatile HeartBeat INSTANCE = null;

    private static volatile Thread heart = null;
    private static int time = 0;

    private static Map<Integer, Map<EventListener, Integer>> timeListeners;
    private static int listenersHandle = 0;

    private static int smallestTimeOut;
    private static int biggestTimeOut;

    private HeartBeat() {
        timeListeners = new LinkedHashMap<>();
        smallestTimeOut = Integer.MAX_VALUE;
        biggestTimeOut = 0;

        //Start heartbeat
        heart = new Thread();//TODO : Add a iterator to visit related classes.
    }

    /**
     * @param eventListener The class that need to listen to events.
     * @param timeOut       Activate after n frames.
     * @return Return a handle of listener.
     */
    public int setEventListener(EventListener eventListener, int timeOut) {//FIXME : Throw Exception if timeOut <= 0
        Map<EventListener, Integer> temp = new HashMap<EventListener, Integer>();
        temp.put(eventListener, timeOut);
        timeListeners.put(listenersHandle, temp);

        //Invoke function when reach the smallest timeout.
        if (timeOut < smallestTimeOut)
            smallestTimeOut = timeOut;

        //Reset time counter if reach the biggest.
        if (timeOut > biggestTimeOut)
            biggestTimeOut = timeOut;

        synchronized (this) {
            return listenersHandle;
        }
    }

    /**
     * Remove a EventListener from queue.
     *
     * @param listenersHandle Handle of the listener.
     */
    public void removeEventListener(int listenersHandle) {
        timeListeners.remove(listenersHandle);
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

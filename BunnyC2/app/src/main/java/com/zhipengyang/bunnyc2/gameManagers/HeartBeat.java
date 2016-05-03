package com.zhipengyang.bunnyc2.gameManagers;

import com.zhipengyang.bunnyc2.data.EventListener;
import com.zhipengyang.bunnyc2.data.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

class Listener {
    private int timeOut;
    private EventListener eventListener;
    private GameAction gameAction;

    public Listener(EventListener eventListener, GameAction gameAction, int timeOut) {
        this.eventListener = eventListener;
        this.gameAction = gameAction;
        this.timeOut = timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public EventListener getEventListener() {
        return eventListener;
    }

    public GameAction getGameAction() {
        return gameAction;
    }

    public void setGameAction(GameAction gameAction) {
        this.gameAction = gameAction;
    }
}

public final class HeartBeat {
    private static volatile HeartBeat INSTANCE = null;

    private static volatile Thread heart = null;
    private static int time = 0;

    private static Map<Integer, Listener> timeListeners;
    private static int listenersHandle = 0;

    private static int smallestTimeOut;
    private static int biggestTimeOut;

    private HeartBeat() {
        synchronized (this) {
            timeListeners = new LinkedHashMap<>();
            smallestTimeOut = Integer.MAX_VALUE;
            biggestTimeOut = 0;

            //Start heartbeat
            //Main loop thread
            heart = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (time % smallestTimeOut == 0) {
                        for (Map.Entry<Integer, Listener> entry : timeListeners.entrySet()) {
                            if (time % entry.getValue().getTimeOut() == 0) {
                                entry.getValue().getEventListener().onEventArrived(entry.getValue().getGameAction());
                            }
                        }
                    }

                    //Increment of time
                    time = time > biggestTimeOut ? time + 1 : 0;

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });//TODO : Add a iterator to visit related classes.
        }
    }

    /**
     * @param eventListener The class that need to listen to events.
     * @param timeOut       Activate after n frames.
     * @return Return a handle of listener.
     */
    public int setEventListener(EventListener eventListener, GameAction gameAction, int timeOut) {//FIXME : Throw Exception if timeOut <= 0
        synchronized (this) {
            timeListeners.put(listenersHandle, new Listener(eventListener, gameAction, timeOut));

            //Invoke function when reach the smallest timeout.
            if (timeOut < smallestTimeOut)
                smallestTimeOut = timeOut;

            //Reset time counter if reach the biggest.
            if (timeOut > biggestTimeOut)
                biggestTimeOut = timeOut;

            return listenersHandle;
        }
    }

    /**
     * Remove a EventListener from queue.
     *
     * @param listenersHandle Handle of the listener.
     */
    public void removeEventListener(int listenersHandle) {
        synchronized (this) {
            timeListeners.remove(listenersHandle);
        }
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

package com.zhipengyang.bunnyc2.data;

/**
 * This is a visitor pattern.
 * In order to run specifics functions while reaching a certain time or event, I use visitor pattern to visit each class.
 */
public interface GameEvent {
    void visit(EventListener eventListener);//FIXME: Add different type of arguments if necessary.
}

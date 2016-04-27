package com.zhipengyang.bunnyc2.canvas.window;

public abstract class WindowDecorator implements IWindow {
    protected IWindow decoratedWindow;

    public WindowDecorator(IWindow decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    public void draw() {
        decoratedWindow.draw();
    }
}

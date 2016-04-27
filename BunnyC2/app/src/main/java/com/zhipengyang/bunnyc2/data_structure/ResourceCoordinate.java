package com.zhipengyang.bunnyc2.data_structure;

/**
 * Use this class to define the coordinate of a resource in canvas.
 */
public class ResourceCoordinate {
    private int x;
    private int y;

    public ResourceCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

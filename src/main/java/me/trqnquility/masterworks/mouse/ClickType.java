package me.trqnquility.masterworks.mouse;

public class ClickType {

    private boolean leftClick, rightClick;

    private int x, y;

    public ClickType(boolean leftClick, boolean rightClick, int x, int y) {
        this.leftClick = leftClick;
        this.rightClick = rightClick;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isLeftClick() {
        return leftClick;
    }

    public boolean isRightClick() {
        return rightClick;
    }

}

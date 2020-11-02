package me.trqnquility.masterworks.location;

public class Position {

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    private int x = 0;
    private int y = 0;

    private int width;
    private int height;

    public static Position of(final int x, final int y) {
        return new Position(x, y);
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void add(Position position) {
        this.add(position.getX(), position.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

}

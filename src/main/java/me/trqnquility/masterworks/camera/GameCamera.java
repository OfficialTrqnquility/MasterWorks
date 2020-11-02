package me.trqnquility.masterworks.camera;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCamera {

    private int x;
    private int y;

    public GameCamera(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

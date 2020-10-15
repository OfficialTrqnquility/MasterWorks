package me.trqnquility.masterworks.camera;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCamera {

    @Getter
    private static GameCamera instance;

    private float x;
    private float y;

    public GameCamera(float x, float y) {
        this.x = x;
        this.y = y;

        instance = this;
    }
}

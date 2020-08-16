package me.trqnquility.masterWorks.worlds;

import java.util.Collections;

public class World {

    private final int width, height, playerSpawnX, playerSpawnY;


    public World(String path) {
        WorldLoader worldLoader= new WorldLoader(path);

        width = worldLoader.getWidth();
        height = worldLoader.getHeight();
        playerSpawnX = worldLoader.getPlayerSpawnX();
        playerSpawnY = worldLoader.getPlayerSpawnY();

    }
}

package me.trqnquility.masterWorks.worlds;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class World {

    private final int width, height, playerSpawnX, playerSpawnY;

    private final;

    public World(String path) {
        WorldLoader worldLoader= new WorldLoader(path);

        width = worldLoader.getWidth();
        height = worldLoader.getHeight();
        playerSpawnX = worldLoader.getPlayerSpawnX();
        playerSpawnY = worldLoader.getPlayerSpawnY();

    }
}

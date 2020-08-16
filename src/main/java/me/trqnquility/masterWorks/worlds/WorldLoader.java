package me.trqnquility.masterWorks.worlds;

import java.util.concurrent.ConcurrentHashMap;

public class WorldLoader {

    private final String worldFile;

    public WorldLoader(String worldFile) {
        this.worldFile = worldFile;
    }


    public ConcurrentHashMap getTiles() {
        return null;
    }

    public int getWidth() {
        return 1;
    }

    public int getHeight() {
        return 1;
    }

    public int getPlayerSpawnX() {
        return 1;
    }

    public int getPlayerSpawnY() {
        return 1;
    }
}

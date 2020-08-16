package me.trqnquility.masterworks.worlds;


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

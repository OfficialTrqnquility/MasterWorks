package me.trqnquility.masterworks.worlds;


import java.awt.*;

public class World {

    private final int width, height, playerSpawnX, playerSpawnY;

    private final int[][] tiles;

    public World(String path) {
        WorldLoader worldLoader= new WorldLoader(path);

        width = worldLoader.getWidth();
        height = worldLoader.getHeight();
        playerSpawnX = worldLoader.getPlayerSpawnX();
        playerSpawnY = worldLoader.getPlayerSpawnY();
        tiles = worldLoader.getTiles();

    }



    public void render(Graphics g) {

    }
    public void tick() {

    }
}

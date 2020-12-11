package me.trqnquility.masterworks.worlds;

import me.trqnquility.masterworks.utils.Utils;

import java.util.Arrays;

public class WorldLoader {

    private String tokens[];
    private int width, height, playerSpawnx, playerSpawnY, spawnX, spawnY;
    private String[][] tiles;
    private String id;

    public WorldLoader(String worldFile) {

        tokens = Utils.loadFileAsString(worldFile).split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        playerSpawnx = Utils.parseInt(tokens[2]);
        playerSpawnY = Utils.parseInt(tokens[3]);
        spawnX = Utils.parseInt(tokens[4]);
        spawnY = Utils.parseInt(tokens[5]);
        id = tokens[6];
        tiles = new String[width][height];
        for(int y = 0;y < height;y++) {
            for(int x = 0;x < width;x++) {
                tiles[x][y] = tokens[(x + y * width + 7)];
            }
        }

    }


    public String[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPlayerSpawnX() {
        return playerSpawnx;
    }

    public int getPlayerSpawnY() {
        return playerSpawnY;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public String getId() {
        return id;
    }
}

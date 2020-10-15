package me.trqnquility.masterworks.worlds;

import me.trqnquility.masterworks.utils.Utils;

import java.util.Arrays;

public class WorldLoader {

    private String tokens[];
    private int width, height, playerSpawnx, playerSpawnY;
    private String[][] tiles;

    public WorldLoader(String worldFile) {

        tokens = Utils.loadFileAsString(worldFile).split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        playerSpawnx = Utils.parseInt(tokens[2]);
        playerSpawnY = Utils.parseInt(tokens[3]);

        tiles = new String[width][height];
        for(int y = 0;y < height;y++) {
            for(int x = 0;x < width;x++) {
                tiles[x][y] = tokens[(x + y * width + 4)];
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
}

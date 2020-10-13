package me.trqnquility.masterworks.worlds;

import me.trqnquility.masterworks.utils.Utils;

public class WorldLoader {

    private String tokens[];
    private int width, height, playerSpawnx, playerSpawnY;
    private int[][] tiles;

    public WorldLoader(String worldFile) {

        tokens = Utils.loadFileAsString(worldFile).split("\\s+");
        width = Utils.parseInt(tokens[1]);
        height = Utils.parseInt(tokens[2]);
        playerSpawnx = Utils.parseInt(tokens[3]);
        playerSpawnY = Utils.parseInt(tokens[4]);

        tiles = new int[width][height];
        for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
            }
        }

    }


    public int[][] getTiles() {
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

package me.trqnquility.masterworks.worlds;


import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.exceptions.NoTileException;
import me.trqnquility.masterworks.tiles.Tile;
import me.trqnquility.masterworks.tiles.TileManager;

import java.awt.*;

public class World {

    private int width, height, playerSpawnX, playerSpawnY;

    private int[][] tiles;

    public World(String path) {
        WorldLoader worldLoader = new WorldLoader(path);

        width = worldLoader.getWidth();
        height = worldLoader.getHeight();
        playerSpawnX = worldLoader.getPlayerSpawnX();
        playerSpawnY = worldLoader.getPlayerSpawnY();
        tiles = worldLoader.getTiles();

    }

    public Tile getTile(int x, int y) throws NoTileException {

        Tile tile = TileManager.getInstance().getTile(tiles[x][y]);

        return tile == null ? null : tile;
    }

    public void render(Graphics g) throws NoTileException {

        for (int row = 0; row < tiles.length; row++) {

            for (int col = 0; col < tiles[row].length; col++) {

                getTile(row, col).render(g, row * Game.getInstance().height / height, col * Game.getInstance().width / width);
            }

        }

    }

    public void tick() {

    }


}

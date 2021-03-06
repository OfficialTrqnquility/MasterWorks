package me.trqnquility.masterworks.worlds;


import com.google.common.collect.Maps;
import lombok.Getter;
import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.entity.model.Entity;
import me.trqnquility.masterworks.entity.model.inanimate.item.EntityItem;
import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.State;
import me.trqnquility.masterworks.tiles.Tile;
import me.trqnquility.masterworks.tiles.TileManager;
import me.trqnquility.masterworks.utils.Utils;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

public class World {

    private int width, height, playerSpawnX, playerSpawnY, spawnX, spawnY;

    private String[][] tiles;

    private  String id;

    private Map<UUID, Entity> entities;

    public World(String path) {
        WorldLoader worldLoader = new WorldLoader(path);

        width = worldLoader.getWidth();
        height = worldLoader.getHeight();
        playerSpawnX = worldLoader.getPlayerSpawnX();
        playerSpawnY = worldLoader.getPlayerSpawnY();
        spawnX = worldLoader.getSpawnX();
        spawnY = worldLoader.getSpawnY();
        id = worldLoader.getId();
        tiles = worldLoader.getTiles();
        entities = Maps.newConcurrentMap();

    }

    public Tile getTile(int x, int y) {

        if (x < 0 || y < 0 || x >= width || y >= height) return TileManager.getInstance().getTile("0:0");

        Tile tile = TileManager.getInstance().getTile(tiles[x][y]);

        return tile == null ? TileManager.getInstance().getTile("0:0") : tile;
    }

    public void render(Graphics g) {

        for (int row = 0; row < tiles.length; row++) {

            for (int col = 0; col < tiles[row].length; col++) {
                int damage = Utils.parseInt(tiles[row][col].split(":").length <= 1 ? "0" : tiles[row][col].split(":")[1]);
                getTile(row, col).render(g, row * Game.getInstance().height / height, col * Game.getInstance().width / width, damage);
            }

        }

        for (Entity entity : entities.values()) {
            entity.render(g);
        }

        ((GameState) State.getState()).getPlayer().render(g);


    }

    public void tick() {

        for (Entity entity : entities.values()) {
            //if (entity.getNeedsTick()) {
                entity.tick();
            //}
        }

        ((GameState) State.getState()).getPlayer().tick();

    }

    public Entity getEntity(UUID uuid) {
        return entities.get(uuid);
    }

    public Map<UUID, Entity> getEntities() {
        return entities;
    }

    public int getPlayerSpawnX() {
        return playerSpawnX;
    }

    public int getPlayerSpawnY() {
        return playerSpawnY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

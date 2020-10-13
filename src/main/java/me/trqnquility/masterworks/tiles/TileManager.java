package me.trqnquility.masterworks.tiles;

import lombok.Getter;
import me.trqnquility.masterworks.exceptions.NoTileException;

@Getter
public class TileManager {

    @Getter
    private static final TileManager instance = new TileManager();

    private final Tile[] tiles;

    public TileManager() {
        tiles = new Tile[256];
    }

    public Tile getTile(int id) throws NoTileException {
        Tile tile = tiles[id];
        if (tile == null) throw new NoTileException("Tile " + id + " does not exist.");
        return tile;
    }

}

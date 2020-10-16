package me.trqnquility.masterworks.tiles;

import lombok.Getter;
import me.trqnquility.masterworks.exceptions.NoTileException;
import me.trqnquility.masterworks.utils.Utils;

@Getter
public class TileManager {

    @Getter
    private static final TileManager instance = new TileManager();

    private final Tile[] tiles;

    public TileManager() {
        tiles = new Tile[256];
        registerTile(new GrassTile());
        registerTile(new DirtTile());
        registerTile(new WaterTile());
        registerTile(new DockTile());
    }

    public void registerTile(Tile tile) {
        tiles[tile.getId()] = tile;
    }

    public Tile getTile(String id) throws NoTileException {
        Tile tile = tiles[Utils.parseInt(id.split(":")[0])];
        if (tile == null) throw new NoTileException("Tile " + id + " does not exist.");
        return tile;
    }

}

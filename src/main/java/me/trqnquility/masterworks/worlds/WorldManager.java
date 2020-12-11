package me.trqnquility.masterworks.worlds;

import com.google.common.collect.Maps;

import java.util.Map;

public class WorldManager {

    private static WorldManager instance;

    private final Map<String, World> worlds;

    private WorldManager() {
        instance = this;
        this.worlds = Maps.newConcurrentMap();
    }

    public static WorldManager getInstance() {
        return instance == null ? new WorldManager() : instance;
    }

    public World getWorld(String id) {
        return worlds.getOrDefault(id, worlds.get("overworld"));
    }

    public void loadWorld(World world) {
        worlds.put(world.getId(), world);
    }
}

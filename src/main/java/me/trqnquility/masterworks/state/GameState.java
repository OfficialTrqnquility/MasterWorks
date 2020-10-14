package me.trqnquility.masterworks.state;

import lombok.Getter;
import lombok.Setter;
import me.trqnquility.masterworks.exceptions.NoTileException;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;

@Getter
@Setter
public class GameState extends State {

    private World world;

    public GameState(World world) {
        this.world = world;
    }


    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) throws NoTileException {
        world.render(g);
    }
}

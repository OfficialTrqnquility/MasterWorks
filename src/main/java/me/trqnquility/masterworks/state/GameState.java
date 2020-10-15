package me.trqnquility.masterworks.state;

import lombok.Getter;
import lombok.Setter;
import me.trqnquility.masterworks.camera.GameCamera;
import me.trqnquility.masterworks.exceptions.NoTileException;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;

@Getter
@Setter
public class GameState extends State {

    private World world;
    private GameCamera camera;

    public GameState(World world) {
        this.world = world;
        this.camera = new GameCamera(world.getPlayerSpawnX(), world.getPlayerSpawnY());
    }


    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) throws NoTileException {

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.translate(camera.getX(), camera.getY());

        world.render(g);

        graphics2D.translate(-camera.getX(), -camera.getY());

    }
}

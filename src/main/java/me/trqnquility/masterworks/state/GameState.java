package me.trqnquility.masterworks.state;

import lombok.Getter;
import lombok.Setter;
import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.camera.GameCamera;
import me.trqnquility.masterworks.entity.factory.EntityFactory;
import me.trqnquility.masterworks.entity.model.Entity;
import me.trqnquility.masterworks.entity.model.living.LivingEntityType;
import me.trqnquility.masterworks.entity.model.living.creature.impl.EntityZombie;
import me.trqnquility.masterworks.entity.model.living.human.impl.EntityPlayer;
import me.trqnquility.masterworks.location.Position;
import me.trqnquility.masterworks.pathfinding.AStar;
import me.trqnquility.masterworks.pathfinding.PathNode;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class GameState extends State {

    private World world;
    private GameCamera camera;

    private final EntityPlayer player;

    private AStar aStar;


    public GameState(World world) {
        this.world = world;
        this.camera = new GameCamera(world.getPlayerSpawnX(), world.getPlayerSpawnY());

        EntityZombie zombie = (EntityZombie) EntityFactory.INSTANCE.newLivingEntity(LivingEntityType.ZOMBIE, Position.of(world.getPlayerSpawnX(), world.getPlayerSpawnY() + 10), BoundingBox.of(20, 17), 10, 10, true);
        world.getEntities().put(zombie.getId(), zombie);
        player = (EntityPlayer) EntityFactory.INSTANCE.newLivingEntity(LivingEntityType.PLAYER, Position.of(world.getPlayerSpawnX(), world.getPlayerSpawnY()), BoundingBox.of(20, 17), 10, 10, true);
        aStar = new me.trqnquility.masterworks.pathfinding.AStar(world);

    }
    List<PathNode> path;

    @Override
    public void tick() {
        Game.getInstance().getKeyManager().tick();
        world.tick();
    }

    @Override
    public void render(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.translate(camera.getX(), camera.getY());

        world.render(g);
        Color color = Color.BLACK;

        if (path != null) {
            for (PathNode node : path) {
                if (node.getPreviousNode() != null) {
                    g.setColor(color);
                    if (color.equals(Color.BLACK)) {
                        color = Color.WHITE;
                    } else color = Color.BLACK;
                    //g.drawLine(node.getPreviousNode().getX() * 32, node.getPreviousNode().getY() * 32, node.getX() * 32, node.getY() * 32);
                    g.drawLine(node.getPreviousNode().getX() * 32 + 16, node.getPreviousNode().getY() * 32 + 16, node.getX() * 32 + 16, node.getY() * 32 + 16);
                }
            }
        }
        graphics2D.translate(-camera.getX(), -camera.getY());

    }

    public void setWorld(World world) {
        this.world = world;
        camera.set(world.getPlayerSpawnX(), world.getPlayerSpawnY());
        player.setPosition(Position.of(world.getPlayerSpawnX(), world.getPlayerSpawnY()));
    }

    public World getWorld() {
        return world;
    }

    public AStar getAStar() {
        return aStar;
    }
}

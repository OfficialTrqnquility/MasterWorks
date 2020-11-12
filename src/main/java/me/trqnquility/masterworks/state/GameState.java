package me.trqnquility.masterworks.state;

import lombok.Getter;
import lombok.Setter;
import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.camera.GameCamera;
import me.trqnquility.masterworks.entity.factory.EntityFactory;
import me.trqnquility.masterworks.entity.model.living.LivingEntityType;
import me.trqnquility.masterworks.entity.model.living.human.impl.EntityPlayer;
import me.trqnquility.masterworks.exceptions.NoTileException;
import me.trqnquility.masterworks.location.Position;
import me.trqnquility.masterworks.pathfinding.PathNode;
import me.trqnquility.masterworks.test.AStar;
import me.trqnquility.masterworks.utils.Utils;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class GameState extends State {

    private World world;
    private GameCamera camera;

    private final EntityPlayer player;

    public GameState(World world) {
        this.world = world;
        this.camera = new GameCamera(world.getPlayerSpawnX(), world.getPlayerSpawnY());

        player = (EntityPlayer) EntityFactory.INSTANCE.newLivingEntity(LivingEntityType.PLAYER, Position.of(world.getPlayerSpawnX(), world.getPlayerSpawnY()), BoundingBox.of(20, 17, 7, 15), 10, 10, true);


    }
    List<PathNode> path;
    private void start() {
//        int[][] tiles = new int[20][20];
//
//        for (int i = 0; i < 20; i++) {
//            for (int ii = 0; ii < 20; ii++) {
//                tiles[ii][i] = Utils.parseInt(world.getTiles()[ii][i].split(":")[0]);
//
//            }

        me.trqnquility.masterworks.pathfinding.AStar aStar = new me.trqnquility.masterworks.pathfinding.AStar(world);
        path = aStar.findPath(0, 0, 3, 3);
        System.out.println(Arrays.toString(path.toArray()));
    }

//        AStar as = new AStar(tiles, 0, 0, true);
//        path = as.findPathTo(16, 10);
//        if (path != null) {
//            path.forEach((n) -> {
//                System.out.print("[" + n.x + ", " + n.y + "] ");
//                tiles[n.y][n.x] = -1;
//            });
//            System.out.printf("\nTotal cost: %.02f\n", path.get(path.size() - 1).g);
//
//        }

    boolean start = true;

    @Override
    public void tick() {
        if (start) start();
        start = false;
        Game.getInstance().getKeyManager().tick();
        world.tick();
    }

    @Override
    public void render(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.translate(camera.getX(), camera.getY());

        world.render(g);
        Color color = Color.BLACK;

        for (PathNode node : path) {
            if (node.getPreviousNode() != null) {
                g.setColor(color);
                if (color.equals(Color.BLACK)) {
                    color = Color.WHITE;
                }
                    else color = Color.BLACK;
                g.drawLine(node.getPreviousNode().getX() * 32, node.getPreviousNode().getY() * 32, node.getX() * 32, node.getY() * 32);
                //g.drawLine(node.getPreviousNode().getX() * 32 + 16, node.getPreviousNode().getY() * 32 - 16, node.getX() * 32 + 16, node.getY() * 32 - 16);
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
}

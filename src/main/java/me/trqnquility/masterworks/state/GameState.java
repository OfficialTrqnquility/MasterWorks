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
import me.trqnquility.masterworks.test.AStar;
import me.trqnquility.masterworks.utils.Utils;
import me.trqnquility.masterworks.worlds.World;

import java.awt.*;
import java.util.List;

@Getter
@Setter
public class GameState extends State {

    private World world;
    private GameCamera camera;

    private final EntityPlayer player;

    public GameState(World world) {
        this.world = world;
        this.camera = new GameCamera(world.getPlayerSpawnX(), world.getPlayerSpawnY());

        player = (EntityPlayer) EntityFactory.INSTANCE.newLivingEntity(LivingEntityType.PLAYER, Position.of(world.getPlayerSpawnX(), world.getPlayerSpawnY()), BoundingBox.of(20, 17, 7, 15), 10, 10,  true);
//
//        int[][]tiles = new int[20][20];
//        for (int row = 0; row < world.getTiles().length; row++) {
//
//            for (int col = 0; col < world.getTiles()[row].length; col++) {
//                int tile = Utils.parseInt(world.getTiles()[row][col].split(":")[0]);
//                tiles[row][col] = tile;
//            }
//        }
//
//        AStar as = new AStar(tiles, 0, 0, true);
//        List<AStar.Node> path = as.findPathTo(15, 18);
//        if (path != null) {
//            path.forEach((n) -> {
//                System.out.print("[" + n.x + ", " + n.y + "] ");
//                tiles[n.y][n.x] = -1;
//            });
//            System.out.printf("\nTotal cost: %.02f\n", path.get(path.size() - 1).g);
//
//            for (int[] maze_row : tiles) {
//                for (int maze_entry : maze_row) {
//                    switch (maze_entry) {
//                        case 0:
//                            System.out.print("_");
//                            break;
//                        case -1:
//                            System.out.print("*");
//                            break;
//                        default:
//                            System.out.print("#");
//                    }
//                }
//                System.out.println();
//            }
//        }
    }


    @Override
    public void tick() {
        Game.getInstance().getKeyManager().tick();
        world.tick();
    }

    @Override
    public void render(Graphics g) throws NoTileException {

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.translate(camera.getX(), camera.getY());

        world.render(g);

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

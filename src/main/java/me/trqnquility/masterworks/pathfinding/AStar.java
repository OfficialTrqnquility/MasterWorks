package me.trqnquility.masterworks.pathfinding;

import com.google.common.collect.Lists;
import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.State;
import me.trqnquility.masterworks.worlds.World;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AStar {

    private final int MOVE_STRAIGHT_COST = 10, MOVE_DIAGONAL_COST = 14;

    private PathNode[][] grid;
    
    private List<PathNode> openList;
    private List<PathNode> closedList;

    public AStar(World world) {
        grid = new PathNode[20][20];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                PathNode node = new PathNode(x, y, world.getTile(x, y).isSolid());
                if (node.getClosed()) {
                    System.out.println("closed = " + x + " " + y);
                }
                grid[y][x] = node;
            }
        }
    }
    
    public List<PathNode> findPath(int startX, int startY, int endX, int endY) {
        PathNode startNode = grid[startY][startX];
        PathNode endNode = grid[endY][endX];

        openList = Lists.newArrayList(startNode);
        closedList = Lists.newArrayList();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                PathNode pathNode = grid[y][x];
                pathNode.setGCost(Integer.MAX_VALUE);
                pathNode.calculateFCost();
                pathNode.setPreviousNode(null);
            }
        }
        startNode.setGCost(0);
        startNode.setHCost(calculateDistance(startNode, endNode));
        startNode.calculateFCost();

        while(!openList.isEmpty()) {
            PathNode currentNode =  getLowestFCostNode(openList);
            if (currentNode.getX() == endX && currentNode.getY() == endY) return calculatePath(endNode);

            openList.remove(currentNode);
            closedList.add(currentNode);

            for (PathNode neighbor : getNeighbors(currentNode).stream().filter(node -> !node.getClosed()).collect(Collectors.toList())) {
                if (closedList.contains(neighbor)) continue;
                if (neighbor.getClosed()) {
                    closedList.add(neighbor);
                    continue;
                }

                double tentativeGCost = currentNode.getGCost() + calculateDistance(currentNode, neighbor);
                System.out.println(tentativeGCost);
                if (tentativeGCost < neighbor.getGCost()) {
                    neighbor.setPreviousNode(currentNode);
                    neighbor.setGCost(tentativeGCost);
                    neighbor.setHCost(calculateDistance(neighbor, endNode));
                    neighbor.calculateFCost();

                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }
                }
            }
            System.out.println("-----");
        }
        //No path found
        return null;
    }

    private List<PathNode> getNeighbors(PathNode centerNode) {
        List<PathNode> neighborList = Lists.newArrayList();

        if (centerNode.getX() - 1 >= 0) {
            neighborList.add(getNode(centerNode.getX() - 1, centerNode.getY()));

            if (centerNode.getY() - 1 >= 0) neighborList.add(getNode(centerNode.getX() - 1, centerNode.getY() - 1));

            if (centerNode.getY() + 1  < ((GameState) State.getState()).getWorld().getHeight()) neighborList.add(getNode(centerNode.getX() - 1, centerNode.getY() + 1));
        }

        if (centerNode.getX() + 1 < ((GameState) State.getState()).getWorld().getWidth()) {
            neighborList.add(getNode(centerNode.getX() + 1, centerNode.getY()));

            if (centerNode.getY() - 1 >= 0) neighborList.add(getNode(centerNode.getX() + 1, centerNode.getY() - 1));

            if (centerNode.getY() + 1  < 20) neighborList.add(getNode(centerNode.getX() + 1, centerNode.getY() + 1));

        }

        if (centerNode.getY() - 1 >= 0) neighborList.add(getNode(centerNode.getX(), centerNode.getY() - 1));

        if (centerNode.getY() + 1 < 20) neighborList.add(getNode(centerNode.getX(), centerNode.getY() + 1));

        return neighborList;
    }

    private PathNode getNode(int x, int y) {
        if (x  >= 20 || y >= 20) System.out.println(x + " " + y);
        return grid[y][x];
    }

    private int calculateDistance(PathNode nodeA, PathNode nodeB) {
        int xDistance = Math.abs(nodeA.getX() - nodeB.getX());
        int yDistance = Math.abs(nodeA.getY() - nodeB.getY());
        int remaining = Math.abs(xDistance - yDistance);
        return MOVE_DIAGONAL_COST * Math.min(xDistance, yDistance) + MOVE_STRAIGHT_COST * remaining;
        //return Math.sqrt(Math.pow(nodeB.getX() - nodeA.getX(), 2) + Math.pow(nodeB.getY() - nodeA.getY(), 2)) * Math.sqrt(Math.pow(nodeB.getX() - nodeA.getX(), 2) + Math.pow(nodeB.getY() - nodeA.getY(), 2)) > 1 ? MOVE_DIAGONAL_COST : MOVE_STRAIGHT_COST;
    }

    private PathNode getLowestFCostNode(List<PathNode> pathNodes) {
        PathNode lowestFCostNode = pathNodes.get(0);
        for (PathNode node : pathNodes) {
            if (lowestFCostNode.getFCost() < node.getFCost()) continue;
            lowestFCostNode = node;
        }
        return lowestFCostNode;
    }

    private List<PathNode> calculatePath(PathNode node) {
        List<PathNode> path = Lists.newArrayList();
        path.add(node);
        PathNode currentNode = node;
        while (currentNode.getPreviousNode() != null) {
            path.add(currentNode.getPreviousNode());
            currentNode = currentNode.getPreviousNode();
        }

        Collections.reverse(path);
        return path;
    }

}

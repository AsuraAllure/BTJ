package edu.MazeProject.MazeGenerators;

import edu.MazeProject.Elements2DMaze.CordNode;

public record WallsNode(CordNode cord, Direction dir) {
    public CordNode cordNextNode() {
        return switch (dir) {
            case TOP -> new CordNode(cord.i() - 1, cord.j());
            case BOT -> new CordNode(cord.i() + 1, cord.j());
            case LEFT -> new CordNode(cord.i(), cord.j() - 1);
            case RIGHT -> new CordNode(cord.i(), cord.j() + 1);
        };
    }

    public enum Direction {
        TOP,
        BOT,
        LEFT,
        RIGHT
    }
}

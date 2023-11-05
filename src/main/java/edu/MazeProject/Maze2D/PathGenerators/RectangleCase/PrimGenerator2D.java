package edu.MazeProject.Maze2D.PathGenerators.RectangleCase;

import edu.MazeProject.Maze2D.Elements2DMaze.Pass;
import edu.MazeProject.Maze2D.Elements2DMaze.RectangleMazeNode2D;
import edu.MazeProject.Maze2D.Elements2DMaze.Wall;
import edu.MazeProject.Maze2D.Structures.RectangleMazeStructures;
import java.util.ArrayList;
import java.util.Random;

/*
Iterative randomized Prim's algorithm (without stack, without sets)

This algorithm is a randomized version of Prim's algorithm.
1. Start with a grid full of walls.
2. Pick a cell, mark it as part of the maze. Add the walls of the cell to the wall list.
3. While there are walls in the list:
    1. Pick a random wall from the list. If only one of the cells that the wall divides is visited, then:
        1. Make the wall a passage and mark the unvisited cell as part of the maze.
        2. Add the neighboring walls of the cell to the wall list.
    2. Remove the wall from the list.
 */

public class PrimGenerator2D implements RectangleMazeGenerator {
    private final RectangleConfiguration config;
    public PrimGenerator2D(RectangleConfiguration conf) {
        config = conf;
    }

    // Prim's Algorithm
    @Override
    public RectangleMazeStructures generate() {

        RectangleMazeNode2D[][] maze = new RectangleMazeNode2D[config.dim1()][config.dim2()];
        boolean[][] mazeFlags = new boolean[config.dim1()][config.dim2()];
        Random rng = new Random(config.seedRandom());
        ArrayList<WallsNode> listOfWalls = new ArrayList<>();

        for (int i = 0; i < config.dim1(); i++) {
            for (int j = 0; j < config.dim2(); j++) {
                maze[i][j] = new RectangleMazeNode2D(new Wall(), new Wall(), new Wall(), new Wall());
                mazeFlags[i][j] = false;
            }
        }

        mazeFlags[0][0] = true;

        listOfWalls.add(new WallsNode(0, 0, Direction.RIGHT));
        listOfWalls.add(new WallsNode(0, 0, Direction.BOT));

        while (listOfWalls.size() != 0) {
            WallsNode nextWall = listOfWalls.get(rng.nextInt(listOfWalls.size()));
            listOfWalls.remove(nextWall);

            CordNode next = nextWall.cordNextNode();
            CordNode prev = new CordNode(nextWall.i, nextWall.j);



            if (!mazeFlags[next.i][next.j]) {
                switch (next.i - prev.i) {
                    case 1:
                        maze[prev.i][prev.j].setBot(new Pass());
                        maze[next.i][next.j].setTop(new Pass());
                        break;
                    case -1:
                        maze[prev.i][prev.j].setTop(new Pass());
                        maze[next.i][next.j].setBot(new Pass());

                        break;
                    default:
                        switch (next.j - prev.j) {
                            case 1 -> {
                                maze[prev.i][prev.j].setRight(new Pass());
                                maze[next.i][next.j].setLeft(new Pass());

                            }
                            case -1 -> {
                                maze[prev.i][prev.j].setLeft(new Pass());
                                maze[next.i][next.j].setRight(new Pass());
                            }
                            default -> {
                            }
                        }
                }

                if (next.j + 1 < config.dim2() && !mazeFlags[next.i][next.j + 1]) {
                    listOfWalls.add(new WallsNode(next.i, next.j, Direction.RIGHT));
                }

                if (next.j != 0 && !mazeFlags[next.i][next.j - 1]) {
                    listOfWalls.add(new WallsNode(next.i, next.j, Direction.LEFT));
                }

                if (next.i + 1 < config.dim2() && !mazeFlags[next.i + 1][next.j]) {
                    listOfWalls.add(new WallsNode(next.i, next.j, Direction.BOT));
                }

                if (next.i != 0 && !mazeFlags[next.i - 1][next.j]) {
                    listOfWalls.add(new WallsNode(next.i, next.j, Direction.TOP));
                }
            }

            mazeFlags[next.i][next.j] = true;
        }

        return new RectangleMazeStructures(maze);
    }

    private enum Direction {
        TOP,
        BOT,
        LEFT,
        RIGHT
    }

    private record CordNode(int i, int j) {
    }

    private record WallsNode(int i, int j, Direction dir) {
        public CordNode cordNextNode() {
            return switch (dir) {
                case TOP -> new CordNode(i - 1, j);
                case BOT -> new CordNode(i + 1, j);
                case LEFT -> new CordNode(i, j - 1);
                case RIGHT -> new CordNode(i, j + 1);
            };
        }
    }
}

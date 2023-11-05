package edu.MazeProject.Maze2D.PathGenerators.RectangleCase;

import edu.MazeProject.Maze2D.Elements2DMaze.Pass;
import edu.MazeProject.Maze2D.Elements2DMaze.RectangleMazeNode2D;
import edu.MazeProject.Maze2D.Elements2DMaze.Wall;
import edu.MazeProject.Maze2D.Structures.RectangleMazeStructures;
import java.util.ArrayList;
import java.util.Random;

public class RectanglePerfectStructureGenerator2D implements RectanglePathGenerator {
    private final RectangleConfiguration config;

    public RectanglePerfectStructureGenerator2D(RectangleConfiguration conf) {
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
            CordNode next = nextWall.toCord();
            CordNode prev = new CordNode(nextWall.i, nextWall.j);


            if (mazeFlags[prev.i][prev.j] ^ mazeFlags[next.i][next.j]) {
                switch (next.i - prev.i) {
                    case 1:
                        maze[prev.i][prev.j] = new RectangleMazeNode2D(
                            maze[prev.i][prev.j].top(),
                            maze[prev.i][prev.j].left(),
                            new Pass(),
                            maze[prev.i][prev.j].right()
                        );
                        maze[next.i][next.j] = new RectangleMazeNode2D(
                            new Pass(),
                            maze[next.i][next.j].left(),
                            maze[next.i][next.j].bot(),
                            maze[next.i][next.j].right()
                        );
                        break;
                    case -1:
                        maze[prev.i][prev.j] = new RectangleMazeNode2D(
                            new Pass(),
                            maze[prev.i][prev.j].left(),
                            maze[prev.i][prev.j].bot(),
                            maze[prev.i][prev.j].right()
                        );
                        maze[next.i][next.j] = new RectangleMazeNode2D(
                            maze[next.i][next.j].top(),
                            maze[next.i][next.j].left(),
                            new Pass(),
                            maze[next.i][next.j].right()
                        );

                        break;
                    default:
                        switch (next.j - prev.j) {
                            case 1 -> {
                                maze[prev.i][prev.j] = new RectangleMazeNode2D(
                                    maze[prev.i][prev.j].top(),
                                    maze[prev.i][prev.j].left(),
                                    maze[prev.i][prev.j].bot(),
                                    new Pass()
                                );

                                maze[next.i][next.j] = new RectangleMazeNode2D(
                                    maze[next.i][next.j].top(),
                                    new Pass(),
                                    maze[next.i][next.j].bot(),
                                    maze[next.i][next.j].right()
                                );

                            }
                            case -1 -> {
                                maze[prev.i][prev.j] = new RectangleMazeNode2D(
                                    maze[prev.i][prev.j].top(),
                                    new Pass(),
                                    maze[prev.i][prev.j].bot(),
                                    maze[prev.i][prev.j].right()
                                );

                                maze[next.i][next.j] = new RectangleMazeNode2D(
                                    maze[next.i][next.j].top(),
                                    maze[next.i][next.j].left(),
                                    maze[next.i][next.j].bot(),
                                    new Pass()
                                );

                            }
                            default -> {
                            }
                        }
                }

                if (next.j + 1 < config.dim2()&& !mazeFlags[next.i][next.j+1])
                    listOfWalls.add(
                        new WallsNode(
                            next.i, next.j, Direction.RIGHT
                        )
                    );

                if (next.j != 0 && !mazeFlags[next.i][next.j-1])
                    listOfWalls.add(
                        new WallsNode(
                            next.i, next.j, Direction.LEFT
                        )
                    );

                if (next.i + 1< config.dim2()&& !mazeFlags[next.i+1][next.j])
                    listOfWalls.add(
                        new WallsNode(
                            next.i, next.j, Direction.BOT
                        )
                    );
                if (next.i != 0 && !mazeFlags[next.i - 1][next.j])
                    listOfWalls.add(
                        new WallsNode(
                            next.i, next.j, Direction.TOP
                        )
                    );
            }
            mazeFlags[next.i][next.j] = true;
            listOfWalls.remove(nextWall);
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
        public CordNode toCord() {
            return switch (dir) {
                case TOP -> new CordNode(i - 1, j);
                case BOT -> new CordNode(i + 1, j);
                case LEFT -> new CordNode(i, j - 1);
                case RIGHT -> new CordNode(i , j + 1);
            };
        }
    }
}

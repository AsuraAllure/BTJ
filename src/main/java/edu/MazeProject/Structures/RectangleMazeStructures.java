package edu.MazeProject.Structures;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.MazeGenerators.Configuration;

public class RectangleMazeStructures {

    private final Configuration config;
    private final MazeNode[][] maze;

    public RectangleMazeStructures(MazeNode[][] m, Configuration c) {
        config = c;
        maze = m;
    }

    public MazeNode[][] getMaze() {
        return maze;
    }

    public Configuration getConfig() {
        return config;
    }

    public MazeNode get(CordNode c) {
        return maze[c.i()][c.j()];
    }

    public MazeNode get(int i, int j) {
        return maze[i][j];
    }

}
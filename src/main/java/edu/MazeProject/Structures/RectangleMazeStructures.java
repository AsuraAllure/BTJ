package edu.MazeProject.Structures;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.Elements2DMaze.Wall;
import edu.MazeProject.MazeGenerators.Configuration;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.Iterator;

public class RectangleMazeStructures implements Iterable<MazeNode[]> {

    private final Configuration config;
    private final MazeNode[][] maze;
    public RectangleMazeStructures(MazeNode[][] m, Configuration c){
        config = c;
        maze = m;
    }

    public Configuration getConfig() {
        return config;
    }
    public MazeNode get(CordNode c){
        return maze[c.i()][c.j()];
    }

    @NotNull
    @Override
    public Iterator<MazeNode[]> iterator() {
        return Arrays.stream(maze).iterator();
    }
}

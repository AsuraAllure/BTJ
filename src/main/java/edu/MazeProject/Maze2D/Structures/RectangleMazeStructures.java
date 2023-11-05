package edu.MazeProject.Maze2D.Structures;

import edu.MazeProject.Maze2D.Elements2DMaze.RectangleMazeNode2D;
import edu.MazeProject.Maze2D.Elements2DMaze.Wall;

public class RectangleMazeStructures implements Structures2D {
    private final RectangleMazeNode2D[][] maze;
    public RectangleMazeStructures(RectangleMazeNode2D[][] m){
        maze = m;
    }
    @Override
    public void print() {
        StringBuilder result = new StringBuilder();
        for(var row : maze) {
            StringBuilder level1 = new StringBuilder();
            StringBuilder level2 = new StringBuilder();
            StringBuilder level3 = new StringBuilder();

            for (var el : row){
                Wall w = new Wall();
                if (el.getTop().equals(w))
                    level1.append("|—|");
                else
                    level1.append("|↓|");

                if (el.getLeft().equals(w))
                    level2.append("|x");
                else
                    level2.append("->x");

                if (el.getRight().equals(w))
                    level2.append("|");

                if (el.getBot().equals(w))
                    level3.append("|—|");
                else
                    level3.append("|↓|");
            }

            result.append(level1);
            result.append('\n');
            result.append(level2);
            result.append('\n');
            result.append(level3);
            result.append('\n');
        }
        System.out.println(result);
    }
}

package edu.MazeProject.Representer;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.Elements2DMaze.NodeElements;
import edu.MazeProject.Elements2DMaze.Wall;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.Structures.RectangleMazeStructures;
import java.io.PrintStream;
import java.util.List;

public class StandartMazeRepresenter {
    private final static String WALL_FIGURE = "| |";
    private final PrintStream outputStream;

    public StandartMazeRepresenter(PrintStream out) {
        outputStream = out;
    }

    private String checkCeil(NodeElements node) {

        if (node.getType().equals(NodeElements.NodeType.WALL)) {
            return "---";
        }

        return WALL_FIGURE;
    }

    private String checkWall(MazeNode node, char fill) {
        StringBuilder builder = new StringBuilder();
        if (node.getLeft().getType().equals(NodeElements.NodeType.WALL)) {
            builder.append("|");
        } else {
            builder.append(" ");
        }

        builder.append(fill);

        if (node.getRight().getType().equals(NodeElements.NodeType.WALL)) {
            builder.append("|");
        } else {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String checkFlour(NodeElements node) {
        if (node.getType().equals(NodeElements.NodeType.WALL)) {
            return "|_|";
        } else {
            return WALL_FIGURE;
        }
    }

    public void printPath(RectangleMazeStructures maze, List<CordNode> path) {
        StringBuilder result = new StringBuilder();
        Configuration conf = maze.getConfig();
        char fillChar;

        for (int i = 0; i < conf.dim1(); i++) {
            StringBuilder level1 = new StringBuilder();
            StringBuilder level2 = new StringBuilder();
            StringBuilder level3 = new StringBuilder();

            for (int j = 0; j < conf.dim2(); j++) {
                if (path.contains(new CordNode(i, j))) {
                    fillChar = '*';
                } else {
                    fillChar = ' ';
                }

                MazeNode el = maze.get(i, j);

                level1.append(checkCeil(el.getTop()));
                level2.append(checkWall(el, fillChar));
                level3.append(checkFlour(el.getBot()));
            }
            result.append(level1);
            result.append('\n');
            result.append(level2);
            result.append('\n');
            result.append(level3);
            result.append('\n');
        }
        String res = result.toString();
        outputStream.println(res);
    }

    public void print(RectangleMazeStructures maze) {
        StringBuilder result = new StringBuilder();
        Configuration c = maze.getConfig();
        String floor = "___".repeat(c.dim2());
        Configuration conf = maze.getConfig();

        for (int i = 0; i < conf.dim1(); i++) {

            StringBuilder level2 = new StringBuilder();

            for (int j = 0; j < conf.dim2(); j++) {
                MazeNode el = maze.get(i, j);
                if (el.getLeft().getClass().equals(Wall.class)) {
                    if (el.getBot().getClass().equals(Wall.class)) {
                        level2.append("|_");
                    } else {
                        level2.append("| ");
                    }
                } else if (el.getBot().getClass().equals(Wall.class)) {
                    level2.append("__");
                } else {
                    level2.append("_ ");
                }

                if (el.getRight().getClass().equals(Wall.class)) {
                    level2.append("|");
                } else {
                    level2.append("_");
                }
            }

            result.append(level2);
            result.append('\n');

        }
        outputStream.println(floor + '\n' + result);
    }
}

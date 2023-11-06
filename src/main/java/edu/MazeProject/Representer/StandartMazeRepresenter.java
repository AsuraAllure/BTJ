package edu.MazeProject.Representer;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.Elements2DMaze.Wall;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.Structures.RectangleMazeStructures;
import java.io.PrintStream;
import java.util.List;

public class StandartMazeRepresenter {
    private final PrintStream outputStream;
    private char centerNode = ' ';

    public StandartMazeRepresenter(PrintStream out) {
        outputStream = out;
    }

    public void printPath(RectangleMazeStructures maze, List<CordNode> path){
        StringBuilder result = new StringBuilder();
        Configuration conf = maze.getConfig();
        char fillChar;


        for(int i = 0; i < conf.dim1(); i++) {
            StringBuilder level1 = new StringBuilder();
            StringBuilder level2 = new StringBuilder();
            StringBuilder level3 = new StringBuilder();

            for (int j = 0; j < conf.dim2(); j++){
                if (path.contains(new CordNode(i,j)))
                    fillChar = '*';
                else
                    fillChar = ' ';

                var el = maze.get(i, j);

                if (el.getTop().getClass().equals(Wall.class))
                    level1.append("---");
                else
                    level1.append("| |");

                if (el.getLeft().getClass().equals(Wall.class))
                    level2.append("|").append(fillChar);
                else
                    level2.append(" ").append(fillChar);

                if (el.getRight().getClass().equals(Wall.class))
                    level2.append("|");
                else
                    level2.append(" ");

                if (el.getBot().getClass().equals(Wall.class))
                    level3.append("|_|");
                else
                    level3.append("| |");
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


    public void print(RectangleMazeStructures maze) {
        StringBuilder result = new StringBuilder();
        Configuration c = maze.getConfig();
        String floor = "___".repeat(c.dim2());
        Configuration conf = maze.getConfig();

        for (int i=0; i < conf.dim1(); i++) {

            StringBuilder level2 = new StringBuilder();

            for (int j =0; j < conf.dim2(); j++) {
                MazeNode el = maze.get(i, j);
                if (el.getLeft().getClass().equals(Wall.class)) {
                    if (el.getBot().getClass().equals(Wall.class)) {
                        level2.append("|_");
                    } else {
                        level2.append("| ");
                    }
                } else
                    if (el.getBot().getClass().equals(Wall.class))
                        level2.append("__");
                    else
                        level2.append("_ ");

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

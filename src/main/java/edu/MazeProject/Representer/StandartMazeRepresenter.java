package edu.MazeProject.Representer;

import edu.MazeProject.Elements2DMaze.CordNode;
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
        char fillChar;
        int i =0;

        for(var row : maze) {
            StringBuilder level1 = new StringBuilder();
            StringBuilder level2 = new StringBuilder();
            StringBuilder level3 = new StringBuilder();
            int j = 0;
            for (var el : row){
                if (path.contains(new CordNode(i,j)))
                    fillChar = '*';
                else
                    fillChar = ' ';

                Wall w = new Wall();

                if (el.getTop().equals(w))
                    level1.append("---");
                else
                    level1.append("| |");

                if (el.getLeft().equals(w))
                    level2.append("|" + fillChar);
                else
                    level2.append(" "+fillChar);

                if (el.getRight().equals(w))
                    level2.append("|");
                else
                    level2.append(" ");

                if (el.getBot().equals(w))
                    level3.append("|_|");
                else
                    level3.append("| |");
                j++;
            }
            i++;
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

        for (var row : maze) {

            StringBuilder level2 = new StringBuilder();

            for (var el : row) {
                Wall w = new Wall();

                if (el.getLeft().equals(w)) {
                    if (el.getBot().equals(w)) {
                        level2.append("|_");
                    } else {
                        level2.append("| ");
                    }
                } else
                    if (el.getBot().equals(w))
                        level2.append("__");
                    else
                        level2.append("_ ");

                if (el.getRight().equals(w)) {
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

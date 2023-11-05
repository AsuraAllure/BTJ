package edu.MazeProject.Representer;

import edu.MazeProject.Elements2DMaze.Wall;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.Structures.RectangleMazeStructures;
import java.io.PrintStream;

public class StandartMazeRepresenter {
    private final PrintStream outputStream;

    public StandartMazeRepresenter(PrintStream out) {
        outputStream = out;
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

package edu.MazeProject.Maze2D.Elements2DMaze;

import edu.MazeProject.MazeElement;

public record RectangleMazeNode2D(
    MazeElement top,
    MazeElement left,
    MazeElement bot,
    MazeElement right
) {

}

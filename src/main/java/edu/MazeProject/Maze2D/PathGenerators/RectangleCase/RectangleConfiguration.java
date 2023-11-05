package edu.MazeProject.Maze2D.PathGenerators.RectangleCase;

import edu.MazeProject.Maze2D.PathGenerators.Configuration2D;

public record RectangleConfiguration(int dim1, int dim2, long seedRandom) implements Configuration2D {
}

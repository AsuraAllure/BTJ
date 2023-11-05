package edu.MazeProject.Maze2D.PathGenerators.RectangleCase;

import edu.MazeProject.Maze2D.PathGenerators.Configuration2D;
import edu.MazeProject.Maze2D.PathGenerators.StructuresGenerator2D;
import edu.MazeProject.Maze2D.Structures.RectangleMazeStructures;


public interface RectanglePathGenerator extends StructuresGenerator2D {
    @Override
    RectangleMazeStructures generate();
}

package edu.MazeProject.Maze2D.PathGenerators.RectangleCase;

import edu.MazeProject.Maze2D.PathGenerators.StructuresGenerator2D;
import edu.MazeProject.Maze2D.Structures.RectangleMazeStructures;


public interface RectangleMazeGenerator extends StructuresGenerator2D {
    @Override
    RectangleMazeStructures generate();
}

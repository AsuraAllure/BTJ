package edu.MazeProject.Maze2D;

import edu.MazeProject.Maze;
import edu.MazeProject.Maze2D.PathGenerators.RectangleCase.RectangleConfiguration;
import edu.MazeProject.Maze2D.PathGenerators.StructuresGenerator2D;
import edu.MazeProject.Maze2D.Structures.Structures2D;

public class Maze2D implements Maze {
    private final Structures2D mazeStructures;

    public Maze2D(StructuresGenerator2D generator2D){
        mazeStructures = generator2D.generate();
    }

    public void print(){

        mazeStructures.print();
    }
}

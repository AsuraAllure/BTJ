package edu.MazeProject.Maze2D;


import edu.MazeProject.Maze2D.PathGenerators.StructuresGenerator2D;
import edu.MazeProject.Maze2D.PathGenerators.RectangleCase.RectanglePerfectStructureGenerator2D;
import edu.MazeProject.Maze2D.PathGenerators.RectangleCase.RectangleConfiguration;

public class Main {

    public static void main(String[] s){
        StructuresGenerator2D gen = new RectanglePerfectStructureGenerator2D(new RectangleConfiguration(4,4, 1201534));
        Maze2D maze = new Maze2D(gen);
        maze.print();
    }
}

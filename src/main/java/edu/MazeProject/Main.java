package edu.MazeProject;


import edu.MazeProject.MazeGenerators.PrimGenerator2D;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.Representer.StandartMazeRepresenter;

public class Main {

    public static void main(String[] s){
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(4,5, 1201534));
        Maze2D maze = new Maze2D(gen, new StandartMazeRepresenter(System.out));
        maze.print();
    }
}

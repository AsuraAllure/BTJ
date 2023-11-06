package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.MazeGenerators.PrimGenerator2D;
import edu.MazeProject.Representer.StandartMazeRepresenter;
import edu.MazeProject.Solvers.BFSSolver;


public class Main {
    public static void main(String[] s) {
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(4, 5, 1201534));
        Maze2D maze = new Maze2D(gen, new StandartMazeRepresenter(System.out));
        BFSSolver solv = new BFSSolver();
        maze.print();
        maze.printPath(solv.solve(maze.getMazeStructures(), new CordNode(0, 0), new CordNode(3, 4)));
    }
}

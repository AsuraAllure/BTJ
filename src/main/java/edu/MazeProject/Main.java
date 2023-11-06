package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.MazeGenerators.PrimGenerator2D;
import edu.MazeProject.Representer.StandartMazeRepresenter;
import edu.MazeProject.Solvers.BFSSolver;
import edu.MazeProject.Solvers.DFSSolver;
import edu.MazeProject.Structures.RectangleMazeStructures;

public class Main {
    public static void main(String[] s) {
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(4, 5, 1201534));

        RectangleMazeStructures str = gen.generate();
        DFSSolver solv = new DFSSolver();
        BFSSolver solv2 = new BFSSolver();
        StandartMazeRepresenter rep = new StandartMazeRepresenter(System.out);
        rep.print(str);

        rep.printPath(str, solv.solve(str, new CordNode(0, 0), new CordNode(3, 4)));
        rep.printPath(str ,solv2.solve(str, new CordNode(0, 0), new CordNode(3, 4)));
    }
}

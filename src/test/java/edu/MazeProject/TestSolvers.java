package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.MazeGenerators.PrimGenerator2D;
import edu.MazeProject.Solvers.BFSSolver;
import edu.MazeProject.Solvers.DFSSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestSolvers {
    @Test
    public void testBFSSolver(){
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(3,3, 10));
        BFSSolver solv = new BFSSolver();
        List<CordNode> expected = List.of(
            new CordNode(2,2),
            new CordNode(2,1),
            new CordNode(2,0),
            new CordNode(1,0),
            new CordNode(0,0)
            );
        Assertions.assertEquals(expected, solv.solve(gen.generate(), new CordNode(0,0), new CordNode(2,2)));
    }

    @Test
    public void testDFSSolver(){
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(3,3, 10));
        DFSSolver solv = new DFSSolver();
        List<CordNode> expected = List.of(
            new CordNode(2,2),
            new CordNode(2,1),
            new CordNode(2,0),
            new CordNode(1,0),
            new CordNode(0,0)
        );
        Assertions.assertEquals(expected, solv.solve(gen.generate(), new CordNode(0,0), new CordNode(2,2)));
    }
}

package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.Elements2DMaze.Pass;
import edu.MazeProject.Elements2DMaze.Wall;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.MazeGenerators.PrimGenerator2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPrimMaze {
    @Test
    public void testPrim(){
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(3,3, 10));
        MazeNode[][] expected = new MazeNode[][]{
            {
                new MazeNode(new Wall(), new Wall(), new Pass(), new Pass()),
                new MazeNode(new Wall(), new Pass(), new Wall(), new Pass()),
                new MazeNode(new Wall(), new Pass(), new Wall(), new Wall()),
            },
            {
                new MazeNode(new Pass(), new Wall(), new Pass(), new Pass()),
                new MazeNode(new Wall(), new Pass(), new Wall(), new Pass()),
                new MazeNode(new Wall(), new Pass(), new Wall(), new Wall()),
            },
            {
                new MazeNode(new Pass(), new Wall(), new Wall(), new Pass()),
                new MazeNode(new Wall(), new Pass(), new Wall(), new Pass()),
                new MazeNode(new Wall(), new Pass(), new Wall(), new Wall()),
            }
        };

        MazeNode[][] prim = gen.generate().getMaze();
        Assertions.assertEquals(expected.length, prim.length);
        for(int i = 0; i < prim.length; i++) {
            Assertions.assertArrayEquals(expected[i], prim[i]);
        }
    }
}

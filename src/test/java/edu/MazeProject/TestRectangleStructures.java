package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Elements2DMaze.MazeNode;
import edu.MazeProject.Elements2DMaze.Pass;
import edu.MazeProject.Elements2DMaze.Wall;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.Structures.RectangleMazeStructures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRectangleStructures {
    @Test
    public void testConfig() {
        RectangleMazeStructures str = new RectangleMazeStructures(new MazeNode[][] {}, new Configuration(1, 2, 6));
        Assertions.assertEquals(new Configuration(1, 2, 6), str.getConfig());
    }

    @Test
    public void testGet() {

        MazeNode n00 = new MazeNode(new Wall(), new Wall(), new Wall(), new Pass());
        MazeNode n01 = new MazeNode(new Wall(), new Pass(), new Wall(), new Wall());
        MazeNode n02 = new MazeNode(new Wall(), new Pass(), new Wall(), new Wall());
        MazeNode n10 = new MazeNode(new Pass(), new Wall(), new Pass(), new Pass());
        MazeNode n11 = new MazeNode(new Wall(), new Pass(), new Wall(), new Wall());
        MazeNode n12 = new MazeNode(new Pass(), new Pass(), new Pass(), new Pass());

        MazeNode[][] mz = new MazeNode[][] {
            {
                n00,
                n01,
                n02
            },
            {
                n10,
                n11,
                n12
            }
        };

        RectangleMazeStructures str = new RectangleMazeStructures(mz, new Configuration(2, 3, 16));

        Assertions.assertEquals(mz, str.getMaze());

        Assertions.assertEquals(n00, str.get(0, 0));
        Assertions.assertEquals(n01, str.get(0, 1));
        Assertions.assertEquals(n02, str.get(0, 2));
        Assertions.assertEquals(n10, str.get(1, 0));
        Assertions.assertEquals(n11, str.get(1, 1));
        Assertions.assertEquals(n12, str.get(1, 2));

        Assertions.assertEquals(n00, str.get(new CordNode(0, 0)));
        Assertions.assertEquals(n01, str.get(new CordNode(0, 1)));
        Assertions.assertEquals(n02, str.get(new CordNode(0, 2)));
        Assertions.assertEquals(n10, str.get(new CordNode(1, 0)));
        Assertions.assertEquals(n11, str.get(new CordNode(1, 1)));
        Assertions.assertEquals(n12, str.get(new CordNode(1, 2)));
    }
}

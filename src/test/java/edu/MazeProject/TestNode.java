package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.Solvers.PairCord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNode {
    @Test
    public void testPairCord(){
        PairCord pairCord = new PairCord(new CordNode(1,2), new CordNode(3,4));
        Assertions.assertEquals(new CordNode(1,2),pairCord.c1());
        Assertions.assertEquals(new CordNode(3,4),pairCord.c2());
    }

}

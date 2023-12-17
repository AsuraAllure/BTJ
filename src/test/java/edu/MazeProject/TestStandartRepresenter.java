package edu.MazeProject;

import edu.MazeProject.Elements2DMaze.CordNode;
import edu.MazeProject.MazeGenerators.Configuration;
import edu.MazeProject.MazeGenerators.PrimGenerator2D;
import edu.MazeProject.Representer.StandartMazeRepresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class TestStandartRepresenter {
    @Test
    public void testPrint() {

        TestPrintStream t = new TestPrintStream();
        TestPrintStream t2 = new TestPrintStream();
        StandartMazeRepresenter repr = new StandartMazeRepresenter(t);
        StandartMazeRepresenter repr2 = new StandartMazeRepresenter(t2);
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(4, 4, 102));
        PrimGenerator2D gen2 = new PrimGenerator2D(new Configuration(10, 10, 6548));
        repr.print(gen.generate());
        repr2.print(gen2.generate());

        Assertions.assertEquals(
            """
____________
| __ ___|| |
|_|| __ || |
| ___|| ___|
|_||_______|
""",
            t.output
        );
        Assertions.assertEquals(
            """
______________________________
| __ ___|| || ___|| _____ || |
| || ________ __ __ ||____|| |
| || _____ || || || _____ || |
|_|| __ ||_|| || || ||___ ___|
|____|| ___||_||_||_|| __ ___|
|______ __ || ___||___ || __ |
|___ __ || __ __ ||___ ||_|| |
|___ ||_||_||_|| ___||___ || |
|___ ___|| ||___ ______||_||_|
|_____________||_____________|
""",
            t2.output
        );
    }

    @Test
    public void testPrintPath() {
        TestPrintStream t = new TestPrintStream();
        StandartMazeRepresenter repr = new StandartMazeRepresenter(t);
        PrimGenerator2D gen = new PrimGenerator2D(new Configuration(4, 4, 102));
        repr.printPath(
            gen.generate(),
            List.of(
                new CordNode(0, 0),
                new CordNode(0, 1),
                new CordNode(1, 1),
                new CordNode(2, 1),
                new CordNode(2, 0),
                new CordNode(3, 0),
                new CordNode(3, 1),
                new CordNode(3, 2),
                new CordNode(3, 3)
            )
        );

        Assertions.assertEquals(
            """
------------
|*  *   || |
| || ||_|| |
| || |---| |
| ||*   || |
|_|| || || |
---| || || |
|*  *||    |
| ||_|| ||_|
| |---| |---
|*||*  *  *|
|_||_||_||_|
""",
            t.output
        );
    }

    private static class VoidOutputStream extends OutputStream {
        @Override
        public void write(int i) {
        }
    }

    private static class TestPrintStream extends PrintStream {
        public String output = "";

        public TestPrintStream() {
            super(new VoidOutputStream());
        }

        @Override
        public void println(String str) {
            output += str;
        }

    }
}

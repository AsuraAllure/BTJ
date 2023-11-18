package edu.project1;

import edu.project1.Representers.Writers.ConsoleWriter;
import org.junit.jupiter.api.Test;

public class TestConsoleWriter {
    @Test
    public void testConsole() {
        ConsoleWriter out = new ConsoleWriter();
        out.print("sfsdg");
    }
}

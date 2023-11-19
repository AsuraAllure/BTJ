package edu.hw6.task3;

import org.junit.jupiter.api.Assertions;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class TestFiltersParameters {
    public static final Path DIR = Path.of(
        System.getProperty("user.home"),
        "testFilter"
    );

    public static void fillDirectory() {
        if (DIR.toFile().exists()) {
            return;
        }

        DIR.toFile().mkdir();

        Path p1 = Path.of(
            DIR.toString(),
            "_regex_.txt"
        );
        Path p2 = Path.of(
            DIR.toString(),
            "10char.txt"
        );
        Path p3 = Path.of(
            DIR.toString(),
            "hiew32.exe"
        );
        Path p4 = Path.of(
            DIR.toString(),
            "PowerPoint.pptx"
        );
        try {
            boolean b = p1.toFile().createNewFile()
                && p2.toFile().createNewFile()
                && p3.toFile().createNewFile()
                && p4.toFile().createNewFile();
            PrintWriter fr1 = new PrintWriter(new FileWriter(p2.toFile()));
            fr1.write("asdasasdp");
            fr1.flush();
            PrintWriter fr2 = new PrintWriter(new FileWriter(p3.toFile()));
            fr2.write("MZasfl;kdsgijwkl;egvfjkdgjmewlskfa");
            fr2.flush();
        } catch (IOException e) {
            Assertions.fail();
        }
    }

}

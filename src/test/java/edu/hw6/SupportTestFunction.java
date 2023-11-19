package edu.hw6;

import org.junit.jupiter.api.Assertions;
import java.io.File;
import java.nio.file.Path;

public class SupportTestFunction {
    public static void deleteDirectory(Path dir) {
        if (dir.toFile().exists()) {
            File dirF = dir.toFile();
            File[] listFiles = dirF.listFiles();
            if (listFiles != null) {
                for (var f : listFiles) {
                    if (!f.delete()) {
                        Assertions.fail();
                    }
                }
            }
            if (!dirF.delete()) {
                Assertions.fail();
            }
        }
    }
}

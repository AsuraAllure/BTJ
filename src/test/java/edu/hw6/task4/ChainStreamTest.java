package edu.hw6.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChainStreamTest {

    @Test
    void createFile() {
        Path nameFile = Path.of(
            System.getProperty("user.home"),
            "testOutputChain",
            "hello.txt"
        );
        if (nameFile.toFile().exists()) {
            nameFile.toFile().delete();
        }

        ChainStream.createFile(nameFile);

        Assertions.assertTrue(nameFile.toFile().exists());
        try (BufferedReader fr = new BufferedReader(new FileReader(nameFile.toFile()))) {
            Assertions.assertEquals(
                List.of(
                    "Programming is learned by writing programs. ― Brian Kernighan"
                ),
                fr.lines().toList()
            );
        } catch (IOException e) {
            Assertions.fail();
        }

    }
}

package edu.hw6.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

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

    }
}

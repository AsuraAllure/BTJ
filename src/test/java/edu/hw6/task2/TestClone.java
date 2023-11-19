package edu.hw6.task2;

import edu.hw6.SupportTestFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class TestClone {
    private String findNewName(Path dir, String name) {
        List<String> filesName = Stream.of(dir.toFile().listFiles()).map(File::getName).toList();

        String newNameFile = name.substring(0, name.length() - 4) + " - копия.txt";

        if (filesName.contains(newNameFile)) {
            int i = 2;
            newNameFile = newNameFile.substring(0, newNameFile.length() - 4) + " (%d).txt".formatted(i);
            while (filesName.contains(newNameFile)) {
                i++;
                newNameFile = newNameFile.substring(0, newNameFile.length() - 4) + " (%d).txt".formatted(i);
            }
        }
        return newNameFile;
    }

    @Test
    public void testClone() {
        Path dir = Path.of(
            System.getProperty("user.home"),
            "testTinkoffClone"
        );
        SupportTestFunction.deleteDirectory(dir);
        dir.toFile().mkdir();

        final String NAME_CLONED_FILE = "Tinkoff Biggest Secret.txt";

        Path file = Path.of(
            dir.toString(),
            NAME_CLONED_FILE
        );

        try {
            if (!file.toFile().exists()) {
                file.toFile().createNewFile();
            } else {
                file.toFile().delete();
                file.toFile().createNewFile();
            }
        } catch (IOException e) {
            Assertions.fail();
        }
        try (FileWriter fw = new FileWriter(file.toFile())) {
            fw.write("Top-Top secret.");
        } catch (IOException e) {
            Assertions.fail();
        }

        String newNameFile2 = "";
        String newNameFile = findNewName(dir, NAME_CLONED_FILE);
        try {
            ClonePath.clonePath(file);
            newNameFile2 = findNewName(dir, NAME_CLONED_FILE);
            ClonePath.clonePath(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> newListName = Stream.of(dir.toFile().listFiles()).map(File::getName).toList();
        Assertions.assertTrue(newListName.contains(newNameFile));
        Assertions.assertTrue(newListName.contains(newNameFile2));
    }
}

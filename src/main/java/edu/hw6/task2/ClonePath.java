package edu.hw6.task2;

import java.io.*;
import java.nio.file.Path;

public class ClonePath {
    public static void clonePath(Path path) throws IOException {
        String cloneNumber = "";
        int i = 2;

        final String FILE_NAME_WITH_EXT = path.getFileName().toString();

        final String FILE_NAME =
            FILE_NAME_WITH_EXT.substring(0, FILE_NAME_WITH_EXT.length() - 4)
            + " - копия";

        Path cloneNamePath = Path.of(
            path.getParent().toString(),
            FILE_NAME + cloneNumber + ".txt"
        );

        while (cloneNamePath.toFile().exists()) {
            cloneNumber = " (%d)".formatted(i);
            cloneNamePath = Path.of(
                path.getParent().toString(),
                FILE_NAME + cloneNumber + ".txt"
            );
            i++;
        }

        File inpute = path.toFile();
        File output = cloneNamePath.toFile();

        output.createNewFile();

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inpute));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {
            out.write(in.readAllBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

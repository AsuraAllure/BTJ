package edu.hw6.task2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class ClonePath {
    private ClonePath(){

    }

    private final static String TXT_EXTENSION = ".txt";

    public static void clonePath(Path path) throws IOException {
        String cloneNumber = "";
        int i = 2;

        final String FILE_NAME_WITH_EXT = path.getFileName().toString();

        final String FILE_NAME = FILE_NAME_WITH_EXT.substring(0, FILE_NAME_WITH_EXT.length() - 4)
                + " - копия";

        Path cloneNamePath = Path.of(
            path.getParent().toString(),
            FILE_NAME + cloneNumber + TXT_EXTENSION
        );

        while (cloneNamePath.toFile().exists()) {
            cloneNumber = " (%d)".formatted(i);
            cloneNamePath = Path.of(
                path.getParent().toString(),
                FILE_NAME + cloneNumber + TXT_EXTENSION
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

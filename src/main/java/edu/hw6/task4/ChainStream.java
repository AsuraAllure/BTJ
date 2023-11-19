package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32C;
import java.util.zip.CheckedOutputStream;

public class ChainStream {

    private ChainStream() {
    }

    public static void createFile(Path filePath) {

        try (var outputStream = Files.newOutputStream(filePath);
             CheckedOutputStream checkedStream = new CheckedOutputStream(outputStream, new CRC32C());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedStream);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                 bufferedOutputStream,
                 StandardCharsets.UTF_8
             );
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {

            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");

        } catch (IOException ignored) {
        }

    }
}

package edu.hw6.task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFilters {
    @Test
    public void test(){
        final AbstractFilter exec = new ExecutableFilter();
        DirectoryStream.Filter<Path> filter = new WritableFilter().and(exec).and(Files::isReadable);

        Path dir = Path.of(
            System.getProperty("user.home"),
            "testFilter"
        );

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

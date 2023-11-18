package edu.hw6.task3.AttributeFilter;

import edu.hw6.task3.TestFilters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReadableFilterTest {

    @Test
    void accept() {
        DirectoryStream.Filter<Path> filter = new ReadableFilter();
        List<String> files = new ArrayList<>();
        List<String> expected = List.of(
            "10char.txt",
            "hiew32.exe",
            "PowerPoint.pptx",
            "re.txt",
            "rwe.txt",
            "_regex_.txt"
        );
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFilters.DIR, filter)) {
            entries.forEach((x) -> files.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }

        Assertions.assertEquals(expected, files);
    }
}

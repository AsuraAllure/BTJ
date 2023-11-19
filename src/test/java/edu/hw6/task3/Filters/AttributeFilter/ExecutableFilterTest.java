package edu.hw6.task3.Filters.AttributeFilter;

import edu.hw6.SupportTestFunction;
import edu.hw6.task3.AttributeFilter.ExecutableFilter;
import edu.hw6.task3.TestFiltersParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class ExecutableFilterTest {

    @Test
    void accept() {
        TestFiltersParameters.fillDirectory();

        DirectoryStream.Filter<Path> filter = new ExecutableFilter();
        Set<String> files = new HashSet<>();
        Set<String> expected = Set.of(
            "10char.txt",
            "hiew32.exe",
            "PowerPoint.pptx",
            "_regex_.txt"
        );
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFiltersParameters.DIR, filter)) {
            entries.forEach((x) -> files.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }

        Assertions.assertEquals(expected, files);
    }
}

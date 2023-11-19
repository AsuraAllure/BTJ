package edu.hw6.task3.Filters;

import edu.hw6.task3.TestFiltersParameters;
import edu.hw6.task3.AbstractFilter;
import edu.hw6.task3.AttributeFilter.ReadableFilter;
import edu.hw6.task3.ComposeFilter;
import edu.hw6.task3.SizeFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class ComposeFilterTest {
    @Test
    void accept() {
        AbstractFilter sizeFilter = new SizeFilter(5, 10);
        AbstractFilter readableFilter = new ReadableFilter();

        DirectoryStream.Filter<Path> composeFilter = new ComposeFilter(sizeFilter, readableFilter);
        Set<String> files = new HashSet<>();
        Set<String> expected = Set.of(
            "10char.txt"
        );

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFiltersParameters.DIR, composeFilter)) {
            entries.forEach((x) -> files.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(expected, files);
    }
}

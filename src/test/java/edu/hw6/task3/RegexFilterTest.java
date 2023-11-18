package edu.hw6.task3;

import edu.hw6.task3.AttributeFilter.ReadableFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class RegexFilterTest {

    @Test
    void accept() {
        DirectoryStream.Filter<Path> filter = new RegexFilter(Pattern.compile("regex"));

        Set<String> files = new HashSet<>();
        Set<String> expected = Set.of(
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

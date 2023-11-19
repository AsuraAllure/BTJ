package edu.hw6.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

class RegexFilterTest {

    @Test
    void accept() {
        DirectoryStream.Filter<Path> filter = new RegexFilter(Pattern.compile("regex"));
        Set<String> files = new HashSet<>();
        Set<String> expected = Set.of(
            "_regex_.txt"
        );

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFiltersParameters.DIR, filter)) {
            entries.forEach((x) -> files.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(expected, files);
    }

    @Test
    public void failConstruction() {
        Assertions.assertThrows(NullPointerException.class, () -> new RegexFilter(null));
    }
}

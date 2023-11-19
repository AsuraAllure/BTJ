package edu.hw6.task3.Filters;

import edu.hw6.task3.TestFiltersParameters;
import edu.hw6.task3.MagicNumberFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class MagicNumberFilterTest {
    @Test
    void accept() {
        TestFiltersParameters.fillDirectory();
        DirectoryStream.Filter<Path> filter = new MagicNumberFilter(new char[] {'M', 'Z'});
        Set<String> files = new HashSet<>();
        Set<String> expected = Set.of(
            "hiew32.exe"
        );

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFiltersParameters.DIR, filter)) {
            entries.forEach((x) -> files.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(expected, files);
    }

    @Test
    void failConstraction() {
        Assertions.assertThrows(NullPointerException.class, () -> new MagicNumberFilter(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MagicNumberFilter(new char[0]));
    }
}

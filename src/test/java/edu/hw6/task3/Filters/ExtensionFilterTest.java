package edu.hw6.task3.Filters;

import edu.hw6.task3.TestFiltersParameters;
import edu.hw6.task3.ExtensionFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class ExtensionFilterTest {
    @Test
    void accept() {
        TestFiltersParameters.fillDirectory();
        DirectoryStream.Filter<Path> filter1 = new ExtensionFilter("txt");
        Set<String> files1 = new HashSet<>();
        Set<String> expected1 = Set.of(
            "10char.txt",
            "_regex_.txt"
        );
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFiltersParameters.DIR, filter1)) {
            entries.forEach((x) -> files1.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(expected1, files1);

        DirectoryStream.Filter<Path> filter2 = new ExtensionFilter("exe");
        Set<String> files2 = new HashSet<>();
        Set<String> expected2 = Set.of(
            "hiew32.exe"
        );
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFiltersParameters.DIR, filter2)) {
            entries.forEach((x) -> files2.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(expected2, files2);
    }

    @Test
    public void failConstruction() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtensionFilter("asfgx"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtensionFilter("ag"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtensionFilter(""));
        Assertions.assertThrows(NullPointerException.class, () -> new ExtensionFilter(null));
    }
}

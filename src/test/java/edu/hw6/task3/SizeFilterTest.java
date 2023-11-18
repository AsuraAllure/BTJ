package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SizeFilterTest {

    @Test
    public void accept() {
        DirectoryStream.Filter<Path> filter1 = new SizeFilter(5);
        DirectoryStream.Filter<Path> filter2 = new SizeFilter(1, 5);
        DirectoryStream.Filter<Path> filter3 = new SizeFilter(9, 10);

        Set<String> files1 = new HashSet<>();
        Set<String> files2 = new HashSet<>();
        Set<String> files3 = new HashSet<>();

        Set<String> expected1 = Set.of(
            "PowerPoint.pptx",
            "re.txt",
            "rwe.txt",
            "_regex_.txt",
            "rw.doc",
            "e.txt",
            "noAt.doc",
            "w.doc",
            "we.txt"
        );
        Set<String> expected2 = Set.of();
        Set<String> expected3 = Set.of(
            "10char.txt"
        );

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFilters.DIR, filter1)) {
            entries.forEach((x) -> files1.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFilters.DIR, filter2)) {
            entries.forEach((x) -> files2.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TestFilters.DIR, filter3)) {
            entries.forEach((x) -> files3.add(x.getFileName().toString()));
        } catch (IOException e) {
            Assertions.fail();
        }



        Assertions.assertEquals(expected1, files1);
        Assertions.assertEquals(expected2, files2);
        Assertions.assertEquals(expected3, files3);
    }

    @Test
    public void shouldThrowIllegalArgumentException(){
        IllegalArgumentException exc1 = Assertions.assertThrows(IllegalArgumentException.class, () -> new SizeFilter(-1));
        IllegalArgumentException exc2 = Assertions.assertThrows(IllegalArgumentException.class, () -> new SizeFilter(-1, 1));
        IllegalArgumentException exc3 = Assertions.assertThrows(IllegalArgumentException.class, () -> new SizeFilter(10, 1));
    }
}

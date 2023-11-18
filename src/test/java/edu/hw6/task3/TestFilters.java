package edu.hw6.task3;

import edu.hw6.task3.AttributeFilter.ExecutableFilter;
import edu.hw6.task3.AttributeFilter.WritableFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFilters {

    public static final Path DIR = Path.of(
        System.getProperty("user.home"),
        "testFilter"
    );

    // Для простоты тестирования, я гарантирую наличие папок и файлов, к которым обращаются тесты
    // и то, что они удовлетворяют ограничениям, наложенным на них.
    @Test
    public void test(){
        final AbstractFilter exec = new ExecutableFilter();
        DirectoryStream.Filter<Path> filter = new WritableFilter().and(exec).and(Files::isReadable);


        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR, filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            Assertions.fail();
        }

    }
}

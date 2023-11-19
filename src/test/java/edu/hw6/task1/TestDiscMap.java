package edu.hw6.task1;

import edu.hw6.SupportTestFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDiscMap {
    @Test
    public void testCreateDirectory() {
        Path dir = Path.of(
            System.getProperty("user.home"),
            "DiscMap"
        );

        SupportTestFunction.deleteDirectory(dir);

        try (DiskMap d1 = new DiskMap(3)) {
        } catch (Exception exception) {
            Assertions.fail();
        }
        Assertions.assertTrue(dir.toFile().exists());
        SupportTestFunction.deleteDirectory(dir);
    }

    @Test
    public void testCreateNewDiscMap() {
        Path dir = Path.of(
            System.getProperty("user.home"),
            "DiscMap"
        );

        SupportTestFunction.deleteDirectory(dir);
        dir.toFile().mkdir();

        try (DiskMap d1 = new DiskMap(3)) {
            d1.put("first", "1");
            d1.put("second", "2");
            d1.put("third", "3");
        } catch (Exception e) {
            Assertions.fail();
        }

        File createdFile = Path.of(
            dir.toString(),
            "935304.txt"
        ).toFile();

        Set<String> setExpectedString = Set.of(
            "third:3",
            "second:2",
            "first:1"
        );
        Set<String> entryMap = new HashSet<>();

        if (createdFile.exists()) {
            try (Scanner fr = new Scanner(createdFile)) {
                String nextLine;
                Pattern delim = Pattern.compile("^(\\w+:\\w+)$");
                int i = 0;
                while (fr.hasNextLine()) {
                    nextLine = fr.nextLine();
                    Matcher m = delim.matcher(nextLine);
                    if (m.find()) {
                        entryMap.add(m.group(1));
                    } else {
                        Assertions.fail();
                    }
                    i++;
                }
            } catch (IOException exception) {
                Assertions.fail();
            }
        } else {
            Assertions.fail();
        }
        Assertions.assertEquals(setExpectedString, entryMap);

        SupportTestFunction.deleteDirectory(dir);
    }

    @Test
    public void testFailLoad() {
        Path pathToFile = Path.of(
            System.getProperty("user.home"),
            "DiscMap",
            "asf4g.txt"
        );
        FileNotFoundException exc = Assertions.assertThrows(FileNotFoundException.class, () -> new DiskMap(pathToFile));
        Assertions.assertEquals(FileNotFoundException.class, exc.getClass());
    }

    @Test
    public void testLoad() {
        Path dir = Path.of(
            System.getProperty("user.home"),
            "DiscMap"
        );
        Path pathToFile = Path.of(
            dir.toString(),
            "49434.txt"
        );

        if (!dir.toFile().exists()) {
            dir.toFile().mkdir();
        }

        if (pathToFile.toFile().exists()) {
            pathToFile.toFile().delete();
        }

        try (FileWriter fw = new FileWriter(pathToFile.toFile())) {
            fw.write("first:1\n");
            fw.write("second:2\n");
            fw.write("third:3\n");
        } catch (IOException e) {
            Assertions.fail();
        }

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("first", "1");
        expectedMap.put("second", "2");
        expectedMap.put("third", "3");

        try (DiskMap d2 = new DiskMap(pathToFile)) {
            Assertions.assertEquals(expectedMap, d2.getMap());
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}

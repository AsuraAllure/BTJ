package edu.hw6.task3;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class MagicNumberFilter implements AbstractFilter {
    // для простоты считается, что магическое число находится в начале файла(смещение 0).

    private final char[] MAGIC_NUMBER;

    public MagicNumberFilter(char[] magicNumber) {
        MAGIC_NUMBER = magicNumber;
    }

    @Override

    public boolean accept(Path path) {
        char[] readied = new char[MAGIC_NUMBER.length];
        try (FileReader fr = new FileReader(path.toFile())) {
            fr.read(readied);
        } catch (IOException e) {
            return false;
        }

        return MAGIC_NUMBER.equals(readied);
    }
}

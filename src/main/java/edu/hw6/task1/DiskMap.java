package edu.hw6.task1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiskMap implements Map<String, String>, AutoCloseable {
    private final Map<String, String> map;
    private final File file;

    public Map<String, String> getMap(){
        return map;
    }

    public DiskMap(Path fromFile) throws IOException {
        file = fromFile.toFile();
        map = new HashMap<>();
        fillMap();
    }

    public DiskMap(long seed) throws IOException{
        file = Path.of(
            System.getProperty("user.home"),
            "DiscMap",
            new Random(seed).nextInt(1, 100000) + ".txt"
        ).toFile();

        File dir = Path.of(
            System.getProperty("user.home"),
            "DiscMap"
        ).toFile();

        if (!dir.exists())
            dir.mkdir();

        file.createNewFile();

        map = new HashMap<>();
        fillMap();
    }
    private void fillMap() throws IOException{
        try (Scanner fr = new Scanner(file)) {
            String nextLine;
            Pattern delim = Pattern.compile("^(\\w+):(\\w+)$");
            while (fr.hasNextLine()) {
                nextLine = fr.nextLine();
                Matcher m = delim.matcher(nextLine);
                if (m.find()) {
                    map.put(m.group(1), m.group(2));
                }
            }
        } catch (IOException exception) {
            throw exception;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return map.containsValue(o);
    }

    @Override
    public String get(Object o) {
        return map.get(o);
    }

    // Недоделано.
    @Nullable
    @Override
    public String put(String key, String value) {
        return map.put(key, value);
    }

    @Override
    public String remove(Object o) {
        return map.remove(o);
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> map) {
        this.map.putAll(map);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    @Override
    public void close() throws Exception {
        try(FileWriter fw = new FileWriter(file)){
            for(var entry: map.entrySet()){
                fw.write("%s:%s\n".formatted(entry.getKey(), entry.getValue()));
            }
        }
    }
}

package edu.LoggerAnalyzer.Parsers;

import edu.LoggerAnalyzer.LogParser;
import edu.LoggerAnalyzer.LogRecords.LogRecord;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class FileParser implements Parser, AutoCloseable {
    private BufferedReader reader;

    public FileParser(Path p) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(p.toFile()));
    }

    @Override
    public Stream<LogRecord> parse() {
        return reader
            .lines()
            .map(LogParser::parseLog)
            .filter(Optional::isPresent)
            .map(Optional::get)
            ;
    }

    @Override
    public void close() throws Exception {
        reader.close();

    }
}

package edu.LoggerAnalyzer.Parsers;

import edu.LoggerAnalyzer.LogRecords.LogRecord;
import java.util.stream.Stream;

public interface Parser extends AutoCloseable {
    Stream<LogRecord> parse();
}

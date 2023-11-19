package edu.LoggerAnalyzer.Analyzers;

import edu.LoggerAnalyzer.LogRecords.LogRecord;
import edu.LoggerAnalyzer.Statistic;

import java.util.stream.Stream;

public interface Analyzer {

    Statistic analizing(Stream<LogRecord> stream);

}

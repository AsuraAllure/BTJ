package edu.hw5.task3.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public class WordParser extends Parser {
    public WordParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public Optional<LocalDate> parse(String rawData) {
        if (rawData.equals("today")) {
            return Optional.of(LocalDate.now(clock));
        }

        if (rawData.equals("tomorrow")) {
            return Optional.of(LocalDate.now(clock).plusDays(1));
        }

        if (rawData.equals("yesterday")) {
            return Optional.of(LocalDate.now(clock).minusDays(1));
        }

        return parser.parse(rawData);
    }
}

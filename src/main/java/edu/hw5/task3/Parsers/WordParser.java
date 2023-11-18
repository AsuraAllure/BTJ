package edu.hw5.task3.Parsers;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Optional;

public class WordParser extends TimeParser {

    public WordParser(Parser parser, Clock clock) {
        super(parser, clock);
    }

    @Override
    public Optional<LocalDate> parse(String rawData) {

        switch (rawData) {
            case "today" -> {
                return Optional.of(LocalDate.now(clock));
            }
            case "tomorrow" -> {
                return Optional.of(LocalDate.now(clock).plusDays(1));
            }
            case "yesterday" -> {
                return Optional.of(LocalDate.now(clock).minusDays(1));
            }
            default -> {
                return parser.parse(rawData);
            }
        }
    }
}

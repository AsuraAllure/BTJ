package edu.hw5.task3.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public class FailParser extends Parser {
    @Override
    public Optional<LocalDate> parse(String rawData) {
        return Optional.empty();
    }
}
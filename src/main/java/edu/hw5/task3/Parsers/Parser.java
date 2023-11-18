package edu.hw5.task3.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Parser {
    protected Parser parser;

    protected Parser(Parser parser) {
        this.parser = parser;
    }

    public abstract Optional<LocalDate> parse(String rawData);
}

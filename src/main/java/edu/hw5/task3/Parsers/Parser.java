package edu.hw5.task3.Parsers;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Optional;

public abstract class Parser {
    protected Parser parser;
    protected Clock clock = Clock.systemDefaultZone();

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public abstract Optional<LocalDate> parse(String rawData);
}

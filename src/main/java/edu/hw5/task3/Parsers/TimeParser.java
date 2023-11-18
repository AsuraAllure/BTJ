package edu.hw5.task3.Parsers;

import java.time.Clock;

public abstract class TimeParser extends Parser {
    protected final Clock clock;

    protected TimeParser(Parser parser, Clock clock) {
        super(parser);
        this.clock = clock;
    }
}

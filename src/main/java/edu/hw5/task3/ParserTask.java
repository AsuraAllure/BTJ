package edu.hw5.task3;

import edu.hw5.task3.Parsers.*;

import java.time.Clock;

public class ParserTask {
    private ParserTask() {

    }

    public static Parser createChainParser(Clock clock) {
        return new AgoParser(new WordParser(new SlashParser(new TireParser(new FailParser())), clock), clock);
    }
}

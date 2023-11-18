package edu.hw5.task3;

import edu.hw5.task3.Parsers.AgoParser;
import edu.hw5.task3.Parsers.FailParser;
import edu.hw5.task3.Parsers.Parser;
import edu.hw5.task3.Parsers.SlashParser;
import edu.hw5.task3.Parsers.TireParser;
import edu.hw5.task3.Parsers.WordParser;

import java.time.Clock;

public class ParserTask {
    private ParserTask() {

    }

    public static Parser createChainParser(Clock clock) {
        return new AgoParser(new WordParser(new SlashParser(new TireParser(new FailParser())), clock), clock);
    }
}

package edu.hw5.task3.Parsers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgoParser extends Parser {
    public AgoParser(Parser p) {
        this.parser = p;
    }

    @Override
    public Optional<LocalDate> parse(String rawData) {
        Pattern pat = Pattern.compile("^(\\d+) (day|days) ago$");
        Matcher m = pat.matcher(rawData);
        if (m.find()) {
            try {
                return Optional.of(LocalDate.now(clock).minusDays(Integer.parseInt(m.group(1))));
            } catch (DateTimeException ex) {
                return parser.parse(rawData);
            }
        } else {
            return parser.parse(rawData);
        }
    }
}

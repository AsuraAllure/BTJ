package edu.hw5.task3.Parsers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TireParser extends Parser {

    public TireParser(Parser nextParser) {
        parser = nextParser;
    }

    @Override
    public Optional<LocalDate> parse(String rawData) {
        Pattern dataPattern = Pattern.compile("^(\\d{4})-(\\d{1,2})-(\\d{1,2})$");
        Matcher m = dataPattern.matcher(rawData);
        if (m.find()) {
            LocalDate date;
            try {
                date = LocalDate.of(
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3))
                );
            } catch (DateTimeException d) {
                return parser.parse(rawData);
            }
            return Optional.of(date);
        } else {
            return parser.parse(rawData);
        }
    }
}

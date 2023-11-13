package edu.hw5.task3.Parsers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlashParser extends Parser {

    public SlashParser(Parser nextParser) {
        parser = nextParser;
    }

    @Override
    public Optional<LocalDate> parse(String rawData) {
        Pattern dataPattern = Pattern.compile("^(\\d{1,2})/(\\d{1,2})/(\\d{4}|\\d{2})$");
        Matcher m = dataPattern.matcher(rawData);
        if (m.find()) {
            LocalDate date;
            try {
                int year = Integer.parseInt(m.group(3));
                if (year < 100) {
                    year += 2000;
                }

                date = LocalDate.of(
                    year,
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(1))
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

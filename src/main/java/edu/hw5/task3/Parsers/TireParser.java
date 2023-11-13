package edu.hw5.task3.Parsers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TireParser extends Parser {

    private static final int YEAR_GROUP = 1;
    private static final int MONTH_GROUP = 2;
    private static final int DAY_GROUP = 3;


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
                    Integer.parseInt(m.group(YEAR_GROUP)),
                    Integer.parseInt(m.group(MONTH_GROUP)),
                    Integer.parseInt(m.group(DAY_GROUP))
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

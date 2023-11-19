package edu.LoggerAnalyzer;

import edu.LoggerAnalyzer.LogRecords.IPAddress;
import edu.LoggerAnalyzer.LogRecords.LogRecord;
import edu.LoggerAnalyzer.LogRecords.RequestStartLine;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    private static final Pattern LOG_PARSE_PATTERN = Pattern.compile(
        "^(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s-\\s(-|\\w+)" +
            "\\s\\[(.+?)\\]\\s\"(GET|POST|PUT|DELETE)\\s([\\/\\w]+)" +
            "\\s(HTTP\\/(1.1|2|1.0))\"\\s(\\d{3})\\s(\\d{1,})" +
            "\\s\"(-|\\.+?)\"\\s\"(.+)\"");
    private static final Pattern IP_PARSE_PATTERN =
        Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public static Optional<LogRecord> parseLog(String logLine) {
        Matcher m = LOG_PARSE_PATTERN.matcher(logLine);
        if (m.find()) {
            LogRecord logRecord = new LogRecord(
                parseIPAddres(m.group(1)),
                m.group(2),
                dateTimeParse(m.group(3)),
                new RequestStartLine(m.group(4), m.group(5), m.group(6)),
                Integer.parseInt(m.group(8)),
                Integer.parseInt(m.group(9)),
                m.group(10),
                m.group(11)
            );
            return Optional.of(logRecord);
        }
        return Optional.empty();
    }

    private static OffsetDateTime dateTimeParse(String dateStr) {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("dd/MMM/yyyy:HH:mm:ss X")
            .toFormatter(Locale.ENGLISH);
        return OffsetDateTime.parse(dateStr, dateTimeFormatter);
    }

    private static IPAddress parseIPAddres(String ipString) {
        int[] ips = Arrays.stream(ipString.split("\\.")).mapToInt(Integer::parseInt).toArray();
        return new IPAddress(ips[0], ips[1], ips[2], ips[3]);
    }

}

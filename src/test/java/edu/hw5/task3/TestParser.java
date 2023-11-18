package edu.hw5.task3;

import edu.hw5.task3.Parsers.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class TestParser {

    @Test
    public void testSuccess() {
        Parser parser = ParserTask.createChainParser(Clock.fixed(
            LocalDate.of(2023, 11, 12).atStartOfDay().toInstant(ZoneOffset.MIN),
            ZoneId.systemDefault()
        ));
        Assertions.assertEquals(LocalDate.of(2020, 10, 10), parser.parse("2020-10-10").get());
        Assertions.assertEquals(LocalDate.of(2020, 12, 2), parser.parse("2020-12-2").get());
        Assertions.assertEquals(LocalDate.of(1976, 3, 1), parser.parse("1/3/1976").get());
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/3/20").get());
        Assertions.assertEquals(LocalDate.of(2023, 11, 11), parser.parse("1 day ago").get());
        Assertions.assertEquals(LocalDate.of(2017, 9, 30), parser.parse("2234 days ago").get());

    }

    @Test
    public void testFail() {
        Parser parser = ParserTask.createChainParser(Clock.fixed(
            LocalDate.of(2023, 11, 12).atStartOfDay().toInstant(ZoneOffset.MIN),
            ZoneId.systemDefault()
        ));

        Assertions.assertTrue(parser.parse("2020-10-55").isEmpty());
        Assertions.assertTrue(parser.parse("2020-14-0").isEmpty());
        Assertions.assertTrue(parser.parse("55/3/1976").isEmpty());
        Assertions.assertTrue(parser.parse("1/34/20").isEmpty());
        Assertions.assertTrue(parser.parse("").isEmpty());
        Assertions.assertTrue(parser.parse("5 day agoos").isEmpty());
        Assertions.assertTrue(parser.parse("tod").isEmpty());
        Assertions.assertTrue(parser.parse("yes").isEmpty());
    }
}

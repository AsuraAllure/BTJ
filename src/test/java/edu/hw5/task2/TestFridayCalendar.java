package edu.hw5.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TestFridayCalendar {
    @Test
    public void testFindFriday() {
        List<String> l2024 = List.of(
            "2024-09-13",
            "2024-12-13"
        );
        Assertions.assertEquals(
            l2024,
            FridayCalendar.findFriday(2024)
        );
        List<String> l1925 = List.of(
            "1925-02-13",
            "1925-03-13",
            "1925-11-13"
        );
        Assertions.assertEquals(l1925, FridayCalendar.findFriday(1925));
    }

    @Test
    public void testAdjuster() {
        Assertions.assertEquals(LocalDate.of(1925, 3, 13), FridayCalendar.nextFriday(LocalDate.of(1925, 2, 25)));
        Assertions.assertEquals(LocalDate.of(1925, 3, 13), FridayCalendar.nextFriday(LocalDate.of(1925, 3, 13)));
        Assertions.assertEquals(LocalDate.of(2024, 12, 13), FridayCalendar.nextFriday(LocalDate.of(2024, 10, 13)));
    }
}

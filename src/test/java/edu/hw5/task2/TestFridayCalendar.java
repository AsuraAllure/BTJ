package edu.hw5.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void testFindNextFriday() {
    }
}

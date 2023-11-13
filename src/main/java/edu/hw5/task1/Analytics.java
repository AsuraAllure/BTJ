package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Analytics {

    private Analytics() {
    }

    private static String convertToReadable(Duration d, int countVisitors) {
        if (countVisitors == 0) {
            return "No visitors";
        }
        return Duration.ofSeconds(d.getSeconds() / countVisitors).toString();
    }

    public static String analise(List<String> sessions) {
        if (sessions == null) {
            throw new NullPointerException();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration d = Duration.ZERO;
        int countVisiters = 0;
        for (var session : sessions) {

            LocalDateTime timeStart = LocalDateTime.parse(session.substring(0, 17), formatter);
            LocalDateTime timeEnd = LocalDateTime.parse(session.substring(20), formatter);
            countVisiters += 1;
            d = d.plus(Duration.between(timeStart, timeEnd));
        }
        return convertToReadable(d, countVisiters);
    }
}

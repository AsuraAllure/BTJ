package edu.hw5.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FridayCalendar {
    private static final int MAX_MONTH = 1;
    private static final int MIN_MONTH = 2;
    private static final int FRIDAY = 5;

    private FridayCalendar() {

    }

    public static List<String> findFriday(int year) {
        List<String> answer = new ArrayList<>();

        LocalDate varDate = LocalDate.of(year, MIN_MONTH, MAX_MONTH);
        while (varDate.getYear() != year + 1) {
            if (varDate.getDayOfWeek().getValue() == FRIDAY) {
                answer.add(varDate.toString());
            }
            varDate = varDate.plusMonths(1);
        }

        return answer;
    }
}

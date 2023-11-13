package edu.hw5.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FridayCalendar {
    private FridayCalendar() {

    }

    public static List<String> findFriday(int year) {
        List<String> answer = new ArrayList<>();

        LocalDate varDate = LocalDate.of(year, 1, 13);
        while (varDate.getYear() != year + 1) {
            if (varDate.getDayOfWeek().getValue() == 5) {
                answer.add(varDate.toString());
            }
            varDate = varDate.plusMonths(1);
        }

        return answer;
    }
}

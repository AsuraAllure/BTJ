package edu.hw6.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HackerNewsTest {

    // Тестирование этой функции требует знание API сайта
    // для получения массива новостей на заданное время.
    @Test
    void hackerNewsTopStories() {
        Assertions.assertNotNull(HackerNews.hackerNewsTopStories());
    }

    @Test
    void newsExist() {
        try {
            Assertions.assertEquals(
                "Mysterious 'Tasmanian devil' space explosion baffles astronomers",
                HackerNews.news(38322952)
            );
            Assertions.assertEquals(
                "NilAway: Practical nil panic detection for Go",
                HackerNews.news(38300425)
            );
        } catch (Exception ex) {
            Assertions.fail();
        }
    }

    @Test
    void newNotExist() {
        try {
            Assertions.assertEquals(
                "",
                HackerNews.news(38322951)
            );
        } catch (Exception ex) {
            Assertions.fail();
        }
    }
}

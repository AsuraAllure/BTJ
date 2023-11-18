package edu.hw3.task5;

import edu.hw3.task5.AscDescSort.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSortContact {

    @Test
    public void testDescSort() {
        Assertions.assertArrayEquals(
            new Contact[] {
                new Contact("Carl", "Gauss"),
                new Contact("Leonhard", "Euler"),
                new Contact("Paul", "Erdos")
            },
            AscDescSort.parseContact(
                new String[] {
                    "Paul Erdos",
                    "Leonhard Euler",
                    "Carl Gauss"
                },
                "DESC"
            )
        );
    }

    @Test
    public void testEmptySort() {
        Assertions.assertArrayEquals(new Contact[0], AscDescSort.parseContact(new String[0], "DESC"));
    }

    @Test
    public void testAscSort() {
        Assertions.assertArrayEquals(
            new Contact[] {
                new Contact("Thomas", "Aquinas"),
                new Contact("Rene", "Descartes"),
                new Contact("David", "Hume"),
                new Contact("John", "Locke")
            },
            AscDescSort.parseContact(
                new String[] {
                    "John Locke",
                    "Thomas Aquinas",
                    "David Hume",
                    "Rene Descartes"
                },
                "ASC"
            )
        );
    }

    @Test
    public void shouldThrowNullException() {
        NullPointerException exc =
            Assertions.assertThrows(NullPointerException.class, () -> AscDescSort.parseContact(null, "DESC"));
        Assertions.assertEquals(NullPointerException.class, exc.getClass());
    }
}

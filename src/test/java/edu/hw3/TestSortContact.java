package edu.hw3;

import edu.hw3.AscDescSort.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSortContact {

    @Test
    public void testSort() {
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

        Assertions.assertArrayEquals(new Contact[0], AscDescSort.parseContact(new String[0], "DESC"));
        Assertions.assertArrayEquals(new Contact[0], AscDescSort.parseContact(null, "DESC"));
    }
}

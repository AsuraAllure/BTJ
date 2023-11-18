package edu.hw3.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TestBackwardIterator {
    @Test
    public void testBIterator() {
        Iterator<Integer> it = new BackwardIterator<Integer, Iterable<Integer>>(List.of(1, 2, 3));
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(3, it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(2, it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals(1, it.next());
        Assertions.assertFalse(it.hasNext());
        Throwable thrown = Assertions.assertThrows(NoSuchElementException.class, it::next);
        Assertions.assertEquals(NoSuchElementException.class, thrown.getClass());
    }
}

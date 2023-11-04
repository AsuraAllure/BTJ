package edu.hw3;

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

        List<Integer> l = List.of(1, 2, 3);
        Iterator<Integer> it2 = new BackwardIterator<Integer, Iterable<Integer>>(l);
        it2.next();
        Throwable thrown2 = Assertions.assertThrows(UnsupportedOperationException.class, it::remove);
        Assertions.assertEquals(UnsupportedOperationException.class, thrown2.getClass());
    }
}

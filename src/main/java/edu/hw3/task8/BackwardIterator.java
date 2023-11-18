package edu.hw3.task8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardIterator<E, T extends Iterable<E>> implements Iterator<E> {
    private final Iterable<E> col;
    private int index;
    private boolean flagRemove = false;

    BackwardIterator(T collection) {
        var iter2 = collection.iterator();
        int s = 0;
        while (iter2.hasNext()) {
            s++;
            iter2.next();
        }

        index = s;
        col = collection;
    }

    @Override
    public boolean hasNext() {
        return index != 0;
    }

    @Override
    public E next() {
        flagRemove = true;
        if (index == 0) {
            throw new NoSuchElementException();
        }

        int i = 0;
        var it = col.iterator();
        while (it.hasNext()) {
            i++;
            if (i == index) {
                index--;
                return it.next();
            }
            it.next();
        }
        return null;
    }

    @Override
    public void remove() {
        if (!flagRemove) {
            throw new IllegalStateException();
        }

        int i = 0;
        var it = col.iterator();
        while (it.hasNext()) {
            i++;
            it.next();
            if (i == index + 1) {
                flagRemove = false;
                it.remove();
                return;
            }
        }
    }
}

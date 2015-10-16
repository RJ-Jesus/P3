package rjj.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BufferedIterator implements Iterable<String> {
    private Reader r;

    public BufferedIterator(final Reader r) {
        this.r = Objects.requireNonNull(r, "Reader can't be null.");
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        BufferedReader br = new BufferedReader(r);
        String next;

        Itr() {
            try {
                next = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
                next = null;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            String toReturn = next;
            try {
                next = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
                next = null;
            }
            return toReturn;
        }
    }
}

package L_09.ex03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private final int ALLOC = 50;
    private E[] arr = (E[]) new Object[ALLOC];
    private int size;

    public boolean add(final E elem) {
        if (isFull())
            arr = Arrays.copyOf(arr, arr.length + ALLOC);
        arr[size++] = elem;
        return true;
    }

    public boolean remove(final E elem) {
        if (elem == null) {
            for (int i = 0; i < size; i++)
                if (arr[i] == null) {
                    System.arraycopy(arr, i + 1, arr, i, size-- - i);
                    return true;
                }
        } else {
            for (int i = 0; i < size; i++)
                if (elem.equals(arr[i])) {
                    System.arraycopy(arr, i + 1, arr, i, size-- - i);
                    return true;
                }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= arr.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int idx;

        @Override
        public boolean hasNext() {
            return idx < size();
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException("No element.");
            return arr[idx++];
        }

        public boolean hasPrevious() {
            return idx >= 0;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException("No element.");
            return arr[idx--];
        }
    }
}

package rjj.collections;

import java.util.Iterator;

public interface BFIterator<E> extends Iterator<E> {
    boolean hasPrevious();

    E previous();
}

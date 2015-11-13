package L_09.ex03;

import java.util.Iterator;

public interface BFIterator<E> extends Iterator<E> {
    boolean hasPrevious();

    E previous();
}

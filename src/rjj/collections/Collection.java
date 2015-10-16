package rjj.collections;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Collection<E> extends Iterable<E> {
    boolean add(E e);

    boolean addAll(Collection<? extends E> c);

    void clear();

    boolean contains(Object o);

    boolean containsAll(Collection<E> c);

    boolean equals(Object o);

    int hashCode();

    boolean isEmpty();

    Iterator<E> iterator();

    default Stream<E> parallelStream() {
        return null;
    }

    boolean remove(Object o);

    boolean removeAll(Collection<E> c);

    default boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    boolean retainAll(Collection<E> c);

    int size();

    default Spliterator<E> spliterator() {
        return null;
    }

    default Stream<E> stream() {
        return null;
    }

    Object[] toArray();

    <T> T[] toArray(T[] a);
}

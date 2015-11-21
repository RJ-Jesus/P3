package rjj.collections;

import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {
    private Node<E> first;
    private int size;

    public boolean add(final E elem) {
        if (isEmpty())
            first = new Node<>(elem);
        else
            new Node<>(first, elem);
        size++;
        return true;
    }

    public boolean remove(final E elem) {
        if (!isEmpty())
            if (elem == null) {
                if (first.elem == null) {
                    first.next.prev = first.prev;
                    first.prev.next = first = first.next;
                    size--;
                    return true;
                }
                Node<E> node = first.next;
                while (node.next != first) {
                    if (node.elem == null) {
                        node.next.prev = node.prev;
                        node.prev.next = node.next;
                        size--;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            } else {
                if (elem.equals(first.elem)) {
                    first.next.prev = first.prev;
                    first.prev.next = first = first.next;
                    size--;
                    return true;
                }
                Node<E> node = first.next;
                while (node.next != first) {
                    if (elem.equals(node.elem)) {
                        node.next.prev = node.prev;
                        node.prev.next = node.next;
                        size--;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public BFIterator<E> iterator() {
        return new Itr();
    }

    private static class Node<E> {
        E elem;
        Node<E> next, prev;

        Node(final E elem) {
            this.elem = elem;
            this.next = this.prev = this;
        }

        Node(final Node<E> node, final E elem) {
            this.elem = elem;
            this.prev = node.prev;
            this.next = node;
            node.prev.next = this;
            node.prev = this;
        }
    }

    private class Itr implements BFIterator<E> {
        Node<E> n = first;
        int counter;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException("No element.");
            final E rtn = n.elem;
            n = n.next;
            counter++;
            return rtn;
        }

        @Override
        public boolean hasPrevious() {
            return counter > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException("No element.");
            counter--;
            return (n = n.prev).elem;
        }
    }
}

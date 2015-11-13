package L_09.ex03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {
    private Node<E> top;
    private int size;

    public boolean add(final E elem) {
        top = new Node<E>(elem, top);
        size++;
        return true;
    }

    public boolean remove(final E elem) {
        if (!isEmpty())
            if (elem == null) {
                if (top.elem == null) {
                    top = top.next;
                    size--;
                    return true;
                }
                Node<E> node = top;
                while (node.next != null && node.next.elem != null)
                    node = node.next;
                if (node.next != null) {
                    node.next = node.next.next;
                    size--;
                    return true;
                }
                return false;
            } else {
                if (elem.equals(top.elem)) {
                    top = top.next;
                    size--;
                    return true;
                }
                Node<E> node = top;
                while (node.next != null && elem.equals(node.next.elem))
                    node = node.next;
                if (node.next != null) {
                    node.next = node.next.next;
                    size--;
                    return true;
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
    public Iterator<E> iterator() {
        return new Itr();
    }

    private static class Node<E> {
        E elem;
        Node<E> next;

        Node(final E elem, final Node<E> node) {
            this.elem = elem;
            next = node;
        }
    }

    private class Itr implements Iterator<E> {
        Node<E> n = top;
        DynamicList<E> reverse = new DynamicList<>();

        @Override
        public boolean hasNext() {
            return n != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException("No element.");
            E rtn = n.elem;
            n = n.next;
            reverse.add(rtn);
            return rtn;
        }

        public boolean hasPrevious() {
            return reverse.size >= 0;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException("No element.");
            return null;
        }
    }
}

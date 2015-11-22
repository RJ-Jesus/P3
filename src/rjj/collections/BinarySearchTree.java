package rjj.collections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Consumer;

public class BinarySearchTree<E extends Comparable<? super E>> implements Iterable<E> {
    private Node<E> root;
    private int size;

    public BinarySearchTree() {
    }

    public boolean add(final E e) {
        if (e == null)
            return false;
        root = add(e, root);
        size++;
        return true;
    }

    private Node<E> add(final E e, Node<E> node) {
        if (node == null)
            node = new Node<>(e);
        else {
            if (e.compareTo(node.elem) < 0)
                node.left = add(e, node.left);
            else
                node.right = add(e, node.right);
        }
        return node;
    }

    public boolean addAll(final Collection<? extends E> c) {
        final int startSize = size;
        c.forEach(this::add);
        return startSize != size;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean contains(final E e) {
        return contains(e, root);
    }

    private boolean contains(final E e, Node<E> node) {
        while (node != null) {
            final int n = e.compareTo(node.elem);
            if (n < 0)
                node = node.left;
            else if (n > 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(final E e) {
        final int startSize = size;
        root = remove(e, root);
        return startSize != size;
    }

    private Node<E> remove(final E e, final Node<E> node) {
        if (node == null)
            return null;
        final int cmp = e.compareTo(node.elem);
        if (cmp < 0)
            node.left = remove(e, node.left);
        else if (cmp > 0)
            node.right = remove(e, node.right);
        else {
            size--;
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                final Node<E> rtn = node.left;
                visitInOrder((elem) -> add(elem, rtn), node.right);
                return rtn;
            }
        }
        return node;
    }

    public void visitAll(final Consumer<? super E> consumer, final Mode mode) {
        switch (mode) {
            case PreOrder:
                visitPreOrder(consumer, root);
                break;
            case InOrder:
                visitInOrder(consumer, root);
                break;
            case PostOrder:
                visitPostOrder(consumer, root);
                break;
            default:
                throw new IllegalArgumentException("Undefined mode.");
        }
    }

    private void visitPreOrder(final Consumer<? super E> consumer, final Node<E> node) {
        if (node != null) {
            consumer.accept(node.elem);
            visitInOrder(consumer, node.left);
            visitInOrder(consumer, node.right);
        }
    }

    private void visitInOrder(final Consumer<? super E> consumer, final Node<E> node) {
        if (node != null) {
            visitInOrder(consumer, node.left);
            consumer.accept(node.elem);
            visitInOrder(consumer, node.right);
        }
    }

    private void visitPostOrder(final Consumer<? super E> consumer, final Node<E> node) {
        if (node != null) {
            visitInOrder(consumer, node.left);
            visitInOrder(consumer, node.right);
            consumer.accept(node.elem);
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        final Queue<E> q = new ArrayDeque<>(size);
        visitAll(q::add, Mode.InOrder);
        return q.iterator();
    }

    public enum Mode {
        PreOrder, InOrder, PostOrder
    }

    private static class Node<E> {
        E elem;
        Node<E> left;
        Node<E> right;

        Node(final E elem) {
            this.elem = elem;
        }
    }
}

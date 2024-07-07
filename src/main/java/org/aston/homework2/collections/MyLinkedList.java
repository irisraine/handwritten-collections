package org.aston.homework2.collections;

import java.util.Collection;

public class MyLinkedList<E extends Comparable<E>> implements MyList<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedList(Collection<? extends E> otherList) {
        for (E element : otherList) {
            add(element);
        }
        this.size = otherList.size();
    }

    @Override
    public void add(E element) {
        Node<E> currentNode = new Node<>(element);
        if (this.head == null) {
            this.head = currentNode;
            this.tail = currentNode;
        } else {
            this.tail.next = currentNode;
            currentNode.prev = tail;
            this.tail = currentNode;
        }
        this.size++;
    }

    @Override
    public void addAll(Collection<E> otherList) {
        for (E element : otherList) {
            add(element);
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        Node<E> currentNode = getNode(index);
        currentNode.data = element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Node<E> currentNode = getNode(index);
        detachNode(currentNode);
    }

    @Override
    public void remove(E element) {
        Node<E> currentNode;
        for (int i = 0; i < this.size; i++) {
            currentNode = getNode(i);
            if (element.equals(currentNode.data)) {
                detachNode(currentNode);
                return;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
        if (index < this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++)
                currentNode = currentNode.next;
        } else {
            currentNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    private void detachNode(Node<E> node) {
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            this.tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.data = null;
        this.size--;
    }

    @Override
    public String toString() {
        StringBuilder listToString = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            listToString.append(get(i)).append(" ");
        }
        return listToString.toString();
    }
}

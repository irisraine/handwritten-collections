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
        if (tail == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            tail.next = currentNode;
            currentNode.prev = tail;
            tail = currentNode;
        }
        size++;
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
        for (int i = 0; i < size; i++) {
            currentNode = getNode(i);
            if (element.equals(currentNode.data)) {
                detachNode(currentNode);
                return;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++)
                currentNode = currentNode.next;
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
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
        size--;
    }

    public static <E extends Comparable<E>> void sort(MyLinkedList<E> myLinkedList) {
        if (myLinkedList.size() < 2)
            return;

        Node<E> firstNode, secondNode;
        E temporaryData;
        boolean isSwapped;
        for (int i = 0; i < myLinkedList.size() - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < myLinkedList.size() - 1 - i; j++) {
                firstNode = myLinkedList.getNode(j);
                secondNode = myLinkedList.getNode(j + 1);
                if (firstNode.data.compareTo(secondNode.data) > 0) {
                    temporaryData = firstNode.data;
                    firstNode.data = secondNode.data;
                    secondNode.data = temporaryData;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    @Override
    public String toString() {
        StringBuilder listToString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            listToString.append(get(i)).append(" ");
        }
        return listToString.toString();
    }
}

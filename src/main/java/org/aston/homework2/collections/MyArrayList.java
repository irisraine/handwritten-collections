package org.aston.homework2.collections;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(Collection<? extends E> otherList) {
        this.elements = Arrays.copyOf(otherList.toArray(), otherList.size());
        this.size = otherList.size();
    }

    @Override
    public void add(E element) {
        if (size == elements.length)
            enlargeCapacity();
        elements[size++] = element;
    }

    @Override
    public void addAll(Collection<E> otherList) {
        for (E element : otherList) {
            add(element);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        elements[index] = element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    @Override
    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element))
                remove(i);
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void enlargeCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
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

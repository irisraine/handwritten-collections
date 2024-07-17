package org.aston.homework2.collections;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(Collection<? extends E> otherList) {
        this.elements = Arrays.copyOf(otherList.toArray(), otherList.size());
        this.size = otherList.size();
    }

    @Override
    public void add(E element) {
        if (this.size == this.elements.length)
            enlargeCapacity(1);
        this.elements[this.size++] = element;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (this.size == this.elements.length)
            enlargeCapacity(1);
        for (int i = this.size; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.size++;
    }

    @Override
    public void addAll(Collection<E> otherList) {
        enlargeCapacity(otherList.size());
        for (E element : otherList) {
            this.elements[this.size++] = element;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) this.elements[index];
    }

    @Override
    public void set(int index, E element) {
        checkIndex(index);
        this.elements[index] = element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[--this.size] = null;
        if (this.elements.length > DEFAULT_CAPACITY && this.size < this.elements.length / 2)
            optimizeCapacity();
    }

    @Override
    public void remove(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                remove(i);
                break;
            }
        }
        if (this.elements.length > DEFAULT_CAPACITY && this.size < this.elements.length / 2)
            optimizeCapacity();
    }

    @Override
    public int size() {
        return this.size;
    }

    private void enlargeCapacity(int additionalCapacity) {
        int newSize = Math.max(this.elements.length + DEFAULT_CAPACITY, this.elements.length + additionalCapacity);
        this.elements = Arrays.copyOf(this.elements, newSize);
    }

    private void optimizeCapacity() {
        int newSize = Math.max(this.elements.length / 2, DEFAULT_CAPACITY);
        this.elements = Arrays.copyOf(this.elements, newSize);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
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

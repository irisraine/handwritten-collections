package org.aston.homework2.collections;

import java.util.Collection;

public interface MyList<E extends Comparable<E>> {
    void add(E element);
    void addAll(Collection<E> otherList);
    E get(int index);
    void set(int index, E element);
    void remove(int index);
    void remove(E elem);
    int size();
}

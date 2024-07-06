package org.aston.homework2.collections;

import java.util.Collection;

public interface MyList<E extends Comparable<E>> {
    void add(E elem);
    void addAll(Collection<E> otherList);
    E get(int index);
    void remove(int index);
    void remove(E elem);
    int size();
}

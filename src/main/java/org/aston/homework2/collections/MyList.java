package org.aston.homework2.collections;

public interface MyList<E extends Comparable<E>> {
    void add(E elem);
    void addAll(MyList<E> otherList);
    void size();
    E get(int index);
    E get(E elem);
    E remove(int index);
    E remove(E elem);
}

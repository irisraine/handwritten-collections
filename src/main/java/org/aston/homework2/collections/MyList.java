package org.aston.homework2.collections;

import java.util.Collection;

public interface MyList<E extends Comparable<E>> {
    void add(E element);
    void add(int index, E element);
    void addAll(Collection<E> otherList);
    E get(int index);
    void set(int index, E element);
    void remove(int index);
    void remove(E elem);
    int size();

    static <E extends Comparable<E>> void sort(MyList<E> myList) {
        if (myList.size() < 2)
            return;
        boolean isSwapped;
        E elementFirst, elementSecond;
        for (int i = 0; i < myList.size() - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < myList.size() - 1 - i; j++) {
                elementFirst = myList.get(j);
                elementSecond = myList.get(j + 1);
                if (elementFirst.compareTo(elementSecond) > 0) {
                    myList.set(j, elementSecond);
                    myList.set(j + 1, elementFirst);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }
}

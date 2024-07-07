package org.aston.homework2;

import org.aston.homework2.collections.*;
import java.util.*;

public class UsageExample {
    public static void main(String[] args) {
        System.out.println("[MyArrayList demonstration]");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("First");
        myArrayList.add("Second");
        myArrayList.add("Third");
        myArrayList.add("Fourth");
        myArrayList.add("Fifth");
        myArrayList.add("Sixth");
        myArrayList.add("Seventh");
        System.out.print("[Initial arraylist contents] : ");
        System.out.println(myArrayList.toString());
        System.out.println("[Add multiple elements from other collection]");
        myArrayList.addAll(new ArrayList<>(Arrays.asList("Tenth", "Eleventh")));
        System.out.print("[MyArrayList contents after add another collection] : ");
        System.out.println(myArrayList.toString());
        System.out.print("[Get element by index] : ");
        System.out.println(myArrayList.get(2));
        System.out.print("[Remove element by index] ");
        myArrayList.remove(0);
        System.out.print("[MyArrayList contents after deleting] : ");
        System.out.println(myArrayList.toString());
        System.out.print("[Remove element by value] ");
        myArrayList.remove("Third");
        System.out.print("[MyArrayList contents after deleting] : ");
        System.out.println(myArrayList.toString());
        System.out.print("[MyArrayList sort] : ");
        MyList.sort(myArrayList);
        System.out.print("[MyArrayList contents after sorting] : ");
        System.out.println(myArrayList.toString());
        myArrayList.set(1, "SETUP");
        System.out.print("[MyArrayList contents after setting specific element] : ");
        System.out.println(myArrayList.toString());

        System.out.println("----------------------------------");

        System.out.println("[MyLinkedList demonstration]");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        myLinkedList.add("Fourth");
        myLinkedList.add("Fifth");
        myLinkedList.add("Sixth");
        myLinkedList.add("Seventh");
        System.out.print("[Initial arraylist contents] : ");
        System.out.println(myLinkedList.toString());
        System.out.println("[Add multiple elements from other collection]");
        myLinkedList.addAll(new LinkedList<>(Arrays.asList("Tenth", "Eleventh")));
        System.out.print("[MyLinkedList contents after add another collection] : ");
        System.out.println(myLinkedList.toString());
        System.out.print("[Get element by index] : ");
        System.out.println(myLinkedList.get(2));
        System.out.print("[Remove element by index] ");
        myLinkedList.remove(0);
        System.out.print("[MyLinkedList contents after deleting] : ");
        System.out.println(myLinkedList.toString());
        System.out.print("[Remove element by value] ");
        myLinkedList.remove("Third");
        System.out.print("[MyLinkedList contents after deleting] : ");
        System.out.println(myLinkedList.toString());
        System.out.print("[MyLinkedList sort] : ");
        MyList.sort(myLinkedList);
        System.out.print("[MyLinkedList contents after sorting] : ");
        System.out.println(myLinkedList.toString());
        myLinkedList.set(1, "SETUP");
        System.out.print("[MyLinkedList contents after setting specific element] : ");
        System.out.println(myLinkedList.toString());
    }
}

package org.aston.homework2;

import org.aston.homework2.collections.*;
import java.util.*;

public class UsageExample {
    public static void main(String[] args) {
        System.out.println("[MyArrayList demonstration]");
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("First");
        myArrayList1.add("Second");
        myArrayList1.add("Third");
        myArrayList1.add("Fourth");
        myArrayList1.add("Fifth");
        myArrayList1.add("Sixth");
        myArrayList1.add("Seventh");
        System.out.print("[Initial arraylist contents] : ");
        System.out.println(myArrayList1.toString());
        System.out.println("[Add multiple elements from other collection]");
        myArrayList1.addAll(new ArrayList<>(Arrays.asList("Tenth", "Eleventh")));
        System.out.print("[MyArrayList contents after add another collection] : ");
        System.out.println(myArrayList1.toString());
        System.out.print("[Get element by index] : ");
        System.out.println(myArrayList1.get(2));
        System.out.print("[Remove element by index] ");
        myArrayList1.remove(0);
        System.out.print("[MyArrayList contents after deleting] : ");
        System.out.println(myArrayList1.toString());
        System.out.print("[Remove element by value] ");
        myArrayList1.remove("Third");
        System.out.print("[MyArrayList contents after deleting] : ");
        System.out.println(myArrayList1.toString());
        System.out.print("[MyArrayList sort] : ");
        MyArrayList.sort(myArrayList1);
        System.out.print("[MyArrayList contents after sorting] : ");
        System.out.println(myArrayList1.toString());
        myArrayList1.set(1, "SETUP");
        System.out.print("[MyArrayList contents after setting specific element] : ");
        System.out.println(myArrayList1.toString());

        System.out.println("----------------------------------");

        System.out.println("[MyLinkedList demonstration]");
        MyLinkedList<String> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.add("First");
        myLinkedList1.add("Second");
        myLinkedList1.add("Third");
        myLinkedList1.add("Fourth");
        myLinkedList1.add("Fifth");
        myLinkedList1.add("Sixth");
        myLinkedList1.add("Seventh");
        System.out.print("[Initial arraylist contents] : ");
        System.out.println(myLinkedList1.toString());
        System.out.println("[Add multiple elements from other collection]");
        myLinkedList1.addAll(new LinkedList<>(Arrays.asList("Tenth", "Eleventh")));
        System.out.print("[MyLinkedList contents after add another collection] : ");
        System.out.println(myLinkedList1.toString());
        System.out.print("[Get element by index] : ");
        System.out.println(myLinkedList1.get(2));
        System.out.print("[Remove element by index] ");
        myLinkedList1.remove(0);
        System.out.print("[MyLinkedList contents after deleting] : ");
        System.out.println(myLinkedList1.toString());
        System.out.print("[Remove element by value] ");
        myLinkedList1.remove("Third");
        System.out.print("[MyLinkedList contents after deleting] : ");
        System.out.println(myLinkedList1.toString());
        System.out.print("[MyLinkedList sort] : ");
        MyLinkedList.sort(myLinkedList1);
        System.out.print("[MyLinkedList contents after sorting] : ");
        System.out.println(myLinkedList1.toString());
        myLinkedList1.set(1, "SETUP");
        System.out.print("[MyArrayList contents after setting specific element] : ");
        System.out.println(myArrayList1.toString());
    }
}

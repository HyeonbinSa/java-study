package datastructure;


import datastructure.linkedlist.MyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ListTest {
    @Test
    public void listTest() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.add(2, 5);

        myLinkedList.printAllNode();
        System.out.println("Size : " + myLinkedList.size());
        assertEquals(myLinkedList.size(), 5);
    }
}

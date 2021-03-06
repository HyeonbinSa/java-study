package datastructure.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LinkedListTest {
    private MyLinkedListByList myLinkedListByList;

    @BeforeEach
    public void init() {
        myLinkedListByList = new MyLinkedListByList();
    }

    @Test
    public void addTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        System.out.println(myLinkedListByList.get(1));
        assertEquals(myLinkedListByList.size(), 3);
    }

    @Test
    public void getTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add("one");
        myLinkedListByList.add("five");
        assertEquals(myLinkedListByList.get(2), 3);
        assertEquals(myLinkedListByList.get(4), "five");
    }

    @Test
    public void setTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add("one");
        myLinkedListByList.add("five");
        myLinkedListByList.set(3, "four");
        assertEquals(myLinkedListByList.get(3), "four");
    }

    @Test
    public void addByIndexTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add("one");
        myLinkedListByList.add("five");
        myLinkedListByList.add(3, "add By Index");
        assertEquals(myLinkedListByList.get(3), "add By Index");
        assertEquals(myLinkedListByList.get(4), "one");
        assertEquals(myLinkedListByList.size(), 6);
    }

    @Test
    public void removeTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add("one");
        myLinkedListByList.add("five");
        assertEquals(myLinkedListByList.remove(3), "one");
        assertEquals(myLinkedListByList.get(3), "five");
        assertEquals(myLinkedListByList.get(2), 3);
        assertEquals(myLinkedListByList.size(), 4);
    }

    @Test
    public void lastIndexTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add("one");
        myLinkedListByList.add("five");
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        assertEquals(myLinkedListByList.indexOf(2), 1);
        assertEquals(myLinkedListByList.lastIndexOf(2), 5);
    }

    @Test
    public void containsTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add("one");
        myLinkedListByList.add("five");
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        assertEquals(myLinkedListByList.contains(2), true);
        assertEquals(myLinkedListByList.contains(4), false);
    }

    @Test
    public void toArrayTest() {
        myLinkedListByList.add(1);
        myLinkedListByList.add(2);
        myLinkedListByList.add(3);
        myLinkedListByList.add(4);
        myLinkedListByList.add(5);
        myLinkedListByList.add(6);
        assertEquals(myLinkedListByList.toArray()[2], 3);
        assertEquals(myLinkedListByList.toArray()[4], 5);
    }
}

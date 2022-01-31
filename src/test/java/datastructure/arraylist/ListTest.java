package datastructure.arraylist;


import datastructure.linkedlist.MyLinkedList;
import datastructure.list.MyArrayListByList;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ListTest {
    private MyArrayListByList myArrayListByList;


    @BeforeEach
    public void initMyArrayList() {
        myArrayListByList = new MyArrayListByList();
    }

    @Test
    public void addListTest() {
        myArrayListByList.add("apple");
        myArrayListByList.add("banana");
        myArrayListByList.add("cherry");
        myArrayListByList.add("egg");
        assertEquals(myArrayListByList.size(), 4);
    }

    @Test
    public void addListByIndexTest() {
        myArrayListByList.add("apple");
        myArrayListByList.add("banana");
        myArrayListByList.add("cherry");
        myArrayListByList.add("egg");
        myArrayListByList.add(2, "coke");
        assertEquals(myArrayListByList.get(2), "coke");
        assertEquals(myArrayListByList.get(4), "egg");
    }

    @Test
    public void isEmptyTest() {
        assertEquals(myArrayListByList.isEmpty(), true);
        myArrayListByList.add("apple");
        assertEquals(myArrayListByList.isEmpty(), false);
    }

    @Test
    public void removeTest() {
        myArrayListByList.add("apple");
        myArrayListByList.add("banana");
        myArrayListByList.add("cherry");
        myArrayListByList.add("egg");
        myArrayListByList.add(2, "coke");
        myArrayListByList.remove("coke");
        assertEquals(myArrayListByList.size(), 4);
        assertEquals(myArrayListByList.get(3), "egg");
        assertEquals(myArrayListByList.remove("coke"), false);
        assertEquals(myArrayListByList.remove(3), "egg");
        assertEquals(myArrayListByList.get(3), null);

    }
}

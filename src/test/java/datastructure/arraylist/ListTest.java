package datastructure.arraylist;


import datastructure.linkedlist.MyLinkedList;
import datastructure.list.MyArrayListByList;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void indexOfTest() {
        myArrayListByList.add("one");
        myArrayListByList.add("two");
        myArrayListByList.add("three");
        myArrayListByList.add("four");
        myArrayListByList.add("two");
        myArrayListByList.add("one");
        assertEquals(myArrayListByList.indexOf("two"), 1);
        assertEquals(myArrayListByList.lastIndexOf("two"), 4);
    }

    @Test
    public void containAllTest() {
        myArrayListByList.add("one");
        myArrayListByList.add("two");
        myArrayListByList.add("three");
        myArrayListByList.add("four");
        ArrayList<String> compare = new ArrayList<>();
        compare.add("one");
        compare.add("two");
        compare.add("four");
        assertEquals(myArrayListByList.containsAll(compare), true);
        compare.add("five");
        assertEquals(myArrayListByList.containsAll(compare), false);
    }

    @Test
    public void addAllTest() {
        myArrayListByList.add("one");
        myArrayListByList.add("two");
        myArrayListByList.add("three");
        myArrayListByList.add("four");
        ArrayList<String> compare = new ArrayList<>();
        compare.add("1");
        compare.add("2");
        compare.add("3");
        compare.add("4");
        myArrayListByList.addAll(compare);
        myArrayListByList.stream().forEach(str -> System.out.print(str + " "));
        assertEquals(myArrayListByList.size(), 8);

    }

    @Test
    public void removeAllTest() {
        myArrayListByList.add("one");
        myArrayListByList.add("two");
        myArrayListByList.add("three");
        myArrayListByList.add("four");
        ArrayList<String> compare = new ArrayList<>();
        compare.add("1");
        compare.add("2");
        compare.add("3");
        compare.add("4");
        assertEquals(myArrayListByList.removeAll(compare), false);
        compare.add("four");
        assertEquals(myArrayListByList.removeAll(compare), true);
        assertEquals(myArrayListByList.size(), 3);
    }

    @Test
    public void retainAllTest() {
        myArrayListByList.add("one");
        myArrayListByList.add("two");
        myArrayListByList.add("three");
        myArrayListByList.add("four");
        ArrayList<String> compare = new ArrayList<>();
        compare.add("one");
        compare.add("two");
        compare.add("three");
        compare.add("four");
        assertEquals(myArrayListByList.retainAll(compare), false);
        compare.add("1");
        assertEquals(myArrayListByList.removeAll(compare), true);
        assertEquals(myArrayListByList.size(), 0);
    }
}

package datastructure;

import datastructure.linkedlist.MyLinkedList;
import datastructure.linkedlist.Node;
import datastructure.list.MyArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        listTest();
//        linkedListTest();
        ArrayList<String> test = new ArrayList<>();
        test.add("one");
        test.add("two");
        test.add("three");
        test.add("four");
        ArrayList<String> compare = new ArrayList<>();
        compare.add("one");
        compare.add("two");
        compare.add("five");
        System.out.println(test.containsAll(compare));
    }

    private static void linkedListTest() {
        System.out.println("[LinkedList Test]");
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.add(2, 5);

        myLinkedList.printAllNode();
        System.out.println("Size : " + myLinkedList.size());

        Node popNode = myLinkedList.pop();
        System.out.println("pop 노드 : " + popNode.getData());
        myLinkedList.printAllNode();
        System.out.println("Size : " + myLinkedList.size());

        Node peekNode = myLinkedList.peek();
        System.out.println("peek 노드 : " + peekNode.getData());
        myLinkedList.printAllNode();
        System.out.println("Size : " + myLinkedList.size());

        Node removeNode = myLinkedList.remove(2);
        System.out.println("remove 노드 : " + removeNode.getData());
        myLinkedList.printAllNode();
        System.out.println("Size : " + myLinkedList.size());

    }

    private static void listTest() {
        System.out.println("[ArrayList Test]");
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(10);
        myArrayList.add(55);
        myArrayList.add(22);
        myArrayList.add(6);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println("Size = " + myArrayList.size());
        Object result = myArrayList.remove(2);
        System.out.println("remove data : " + result);
        System.out.println("size = " + myArrayList.size());
        System.out.println("2번째 인덱스 : " + myArrayList.get(2));
        System.out.println("6의 위치 : " + myArrayList.indexOf(6));
        myArrayList.printList();

        myArrayList.add(2, 11);
        myArrayList.printList();
        System.out.println();
    }
}

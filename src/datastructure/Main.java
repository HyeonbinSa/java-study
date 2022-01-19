package datastructure;

import datastructure.list.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(10);
        myArrayList.add(55);
        myArrayList.add(22);
        myArrayList.add(6);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println("size = " + myArrayList.size());
        Object result = myArrayList.remove(2);
        System.out.println("제거된 숫자 : " + result);
        System.out.println("size = " + myArrayList.size());
        System.out.println("2번째 인덱스 : " + myArrayList.get(2));
        System.out.println("6의 인덱스 : " + myArrayList.indexOf(6));
        myArrayList.printList();
    }
}

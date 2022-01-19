package datastructure.list;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 구현 목록
 * 1. size()
 * 2. isEmpty()
 * 3. toArray()
 * 4. add()
 * 5. remove()
 * 6. clear()
 * 7. get()
 * 8. set()
 * 9. indexOf()
 * 10. toString
 */

public class MyArrayList {
    private Object[] array = null;
    private int size = 0;
    private int capacity = 0;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
        int size = 0;
    }

    public MyArrayList() {
        this.capacity = 1;
        array = new Object[capacity];
        int size = 0;
    }

    // 1. size()
    public int size() {
        return this.size;
    }

    // 2. isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    // 3. toArray()
    public Object[] toArray() {
        return array;
    }

    // 4. add()
    public void add(Object element) {
        if (size == capacity) {
            extendArray();
        }
        array[size++] = element;
    }

    // 5. remove()
    public Object remove(int index) {
        if (size <= index) {
            System.out.println("사이즈보다 큰 index는 제거할 수 없습니다.");
            return null;
        }
        Object remove = array[index];
        array[index] = null;
        size -= 1;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        return remove;
    }

    // 6. clear()
    public void clear() {
        array = null;
        size = 0;
        capacity = 0;
    }

    // 7. get()
    public Object get(int index) {
        return array[index];
    }

    // 9. indexOf()
    public int indexOf(Object findElement) {
        int index = 0;
        for (Object element : array) {
            if (element.equals(findElement)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    // toString
    public void printList() {
//        Stream<Object> stream = Arrays.stream(array);
//        stream.forEach(element -> System.out.print(element + " "));
//        System.out.println();
        for(Object element : array){
            if(element != null){
                System.out.print(element +" ");
            }
        }
    }

    // add 시 확장
    private void extendArray() {
        this.capacity += 1;
        Object[] tempArray = new Object[capacity];
        copyArray(tempArray, array);
        array = new Object[capacity];
        copyArray(array, tempArray);
    }

    private void copyArray(Object[] newArray, Object[] oldArray) {
        int index = 0;
        for (Object element : oldArray) {
            newArray[index++] = element;
        }
    }
}

package datastructure.linkedlist;

import java.util.*;

public class MyLinkedListByList<E> implements List<E> {

    // LinkedList Node
    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return "Node(" + data + ")";
        }
    }

    private int size;
    private Node head;

    public MyLinkedListByList() {
        size = 0;
        head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        Node addNode = new Node(e);
        // 1. head가 비어있는지 확인
        if (head == null) {
            head = addNode;
            size++;
            return true;
        }
        // 2. 마지막 Node 탐색
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = addNode;
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E data : c) {
            add(data);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E data : c) {
            add(index++, data);
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node currentNode = head;
        int index = 0;
        while (currentNode.next != null) {
            array[index++] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;

        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;

        return flag;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public E get(int index) {
        Node node = getNode(index);
        return node.data;
    }


    @Override
    public E set(int index, E element) {
        Node node = getNode(index);
        node.data = element;
        return node.data;
    }

    private Node getNode(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public void add(int index, E element) {
        Node prevNode = getNode(index - 1);
        Node nextNode = prevNode.next;
        Node addNode = new Node(element);
        prevNode.next = addNode;
        addNode.next = nextNode;
        size++;
    }

    @Override
    public E remove(int index) {
        Node prevNode = getNode(index - 1);
        Node removeNode = prevNode.next;
        Node nextNode = removeNode.next;
        prevNode.next = nextNode;
        size--;
        return removeNode.data;
    }

    @Override
    public int indexOf(Object o) {
        Node currentNode = head;
        int index = 0;
        while (currentNode.next != null) {
            if (currentNode.data.equals(o)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node currentNode = head;
        int index = 0;
        int result = -1;
        while (currentNode.next != null) {
            if (currentNode.data.equals(o)) {
                result = index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

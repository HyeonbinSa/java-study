package datastructure.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayListByList<T> implements List<T> {
    int size;
    private T[] array;

    public MyArrayListByList() {
        /**
         * 초기 배열 크기 10으로 지정
         */
        array = (T[]) new Object[10];
        size = 0;
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
    public boolean contains(Object o) {
        for (T object : array) {
            if (object.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size >= array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            copyArray(newArray);
            array = newArray;
        }
        array[size] = t;
        size++;
        return true;
    }

    // 배열 사이즈 초과 시 배열 확장
    private void copyArray(T[] newArray) {
        int index = 0;
        for (T object : array) {
            newArray[index++] = object;
        }
    }

    @Override
    public T remove(int index) {
        T object = get(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return object;
    }


    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        array = (T[]) new Object[10];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        T old = get(index);
        array[index] = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);
        for (int i = size - 1; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

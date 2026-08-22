package com.jmp.dsa;

class MyArrayList<T> {

    private Object[] arr;
    private int size;

    public MyArrayList() {
        arr = new Object[0];
        size = 0;
    }

    public boolean add(Object value) {

        // Check whether capacity is available
        if (size == arr.length) {
            grow();
        }

        arr[size] = value;
        size++;

        return true;
    }

    private void grow() {

        int oldCapacity = arr.length;

        int newCapacity;

        if (oldCapacity == 0) {
            newCapacity = 10;
        } else { //add the load factor logic here
            newCapacity = oldCapacity + (oldCapacity >> 1);
        }

        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }

        arr = newArray;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arr[index];
    }

    public Object remove(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object removedElement = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // 4. Clear the last element
        arr[size - 1] = null;

        // 5. Decrease size
        size--;

        // 6. Return removed element
        return removedElement;
    }

    public int size() {
        return size;
    }
}

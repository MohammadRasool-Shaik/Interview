/**
 *
 */
package org.rash.collections;

/**
 * @author Ammi
 *
 */
public class CustomArrayList<E extends Number> {

    private final int INITIAL_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public CustomArrayList() {
        elementData = new Object[INITIAL_CAPACITY];
    }

    public CustomArrayList(int capacity) {
        if (capacity > 0)
            elementData = new Object[capacity];
        else
            elementData = new Object[INITIAL_CAPACITY];
    }

    public void add(E element) {
        if (elementData.length == size)
            ensureCapacity();
        elementData[size++] = element;
    }

    public void add(E element, int index) {
        if (elementData.length == size)
            ensureCapacity();
        for (int i = size; i >= index; i--)
            elementData[i] = elementData[i - 1];
        elementData[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        E removedElement = (E) elementData[index];
        for (int i = index; i < size - 1; i++)
            elementData[i] = elementData[i + 1];
        size--;
        return removedElement;
    }

    public void display() {
        for (int i = 0; i < size; i++)
            System.out.print(elementData[i] + "\t");

    }

    private void ensureCapacity() {
        int newCapacity = elementData.length * 2;
        elementData = copyOf(elementData, newCapacity);

    }

    @SuppressWarnings("unchecked")
    private E[] copyOf(Object[] elementData, int newCapacity) {
        Object[] newElementData = new Object[newCapacity];
        for (int i = 0; i < elementData.length; i++)
            newElementData[i] = elementData[i];
        return (E[]) newElementData;
    }

}

package class_examples;

import java.util.*;

public class DynamicArray<E> implements Iterator<E>, Iterable<E>
{
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int length = 0;
    private int current = 0;

    private E elements[];

    /**
     * Creates a new dynamic array with the default capacity.
     */
    @SuppressWarnings("unchecked")
    public DynamicArray()
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Creates a new dynamic array with the given capacity.
     * 
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity)
    {
        elements = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Resizes the elements array to twice its size.
     * 
     * @return void
     */
    private void resize()
    {
        int capacity = this.capacity * 2;
        elements = Arrays.copyOf(elements, capacity);

        this.capacity = capacity;
    }

    /**
     * Returns the number of elements present in the dynamic array instance.
     * 
     * @return int
     */
    public int length()
    {
        return length;
    }

    /**
     * Checks if dynamic array instance has elements.
     * 
     * @return boolean
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Adds element to internal array.
     * 
     * @param E element
     */
    public void add(E element)
    {
        if (length == elements.length) {
            resize();
        }

        elements[length] = element;
        length++;
    }

    /**
     * Adds element to internal array on the given position.
     * 
     * @param E element
     */
    public void addAt(int position, E element)
    {
        checkPositionWithinBounds(position);

        /*
         * If the element should be placed on the last position, the add() method can
         * handle it.
         */
        if (position == length) {
            add(element);
            return;
        }

        if (length == elements.length) {
            resize();
        }

        /*
         * Put the element on the requested position and move all other elements to the
         * right.
         */
        for (int j = position; j <= length; j++) {
            E tmp = elements[j];
            elements[j] = element;
            element = tmp;
        }

        length++;
    }

    /**
     * Returns element on given position.
     * 
     * @param int position
     * @return E
     * @throws IndexOutOfBoundsException
     */
    public E getAt(int position) throws IndexOutOfBoundsException
    {
        checkPositionWithinBounds(position);

        return elements[position];
    }

    /**
     * Removes element on given position.
     * 
     * @param position
     * @throws IndexOutOfBoundsException
     */
    public void removeAt(int position) throws IndexOutOfBoundsException
    {
        if (length == 1) {
            clear();
            return;
        }

        E toRemove = getAt(position);

        @SuppressWarnings("unchecked")
        E[] copy = (E[]) new Object[capacity];

        int index = 0;
        for (int i = 0; i < length; i++) {
            E current = elements[i];

            if (current.equals(toRemove)) {
                continue;
            }

            copy[index] = current;
            index++;
        }

        elements = copy;
        length--;
    }

    /**
     * Checks that the given position is valid.
     * 
     * @throws IndexOutOfBoundsException
     */
    private void checkPositionWithinBounds(int position) throws IndexOutOfBoundsException
    {
        if (position > length || position < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %s is out of bounds!", position));
        }
    }

    /**
     * Clears the internal array of elements.
     */
    @SuppressWarnings("unchecked")
    public void clear()
    {
        length = 0;

        if (capacity != DEFAULT_CAPACITY) {
            elements = (E[]) new Object[capacity];
            return;
        }

        elements = (E[]) new Object[DEFAULT_CAPACITY];
        return;
    }

    /**
     * Returns a string representation of the dynamic vector instance.
     */
    public String toString()
    {
        return Arrays.toString(elements);
    }

    @Override
    /**
     * Iterator method.
     */
    public boolean hasNext()
    {
        return current < length;
    }

    @Override
    /**
     * Iterator method.
     */
    public E next()
    {
        return getAt(current++);
    }

    @Override
    /**
     * Somewhat silly iterator method.
     */
    public Iterator<E> iterator()
    {
        return this;
    }
}

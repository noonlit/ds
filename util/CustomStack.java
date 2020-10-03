package util;

import java.util.Arrays;

public class CustomStack<E>
{
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int length = 0;
    
    private E elements[];
    
    @SuppressWarnings("unchecked")
    public CustomStack()
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }
    
    @SuppressWarnings("unchecked")
    public CustomStack(int capacity)
    {
        elements = (E[]) new Object[capacity];
        this.capacity = capacity;
    }
    
    /**
     * Adds element to stack.
     * 
     * @param E element
     */
    public void push(E element)
    {
        if (length == elements.length) {
            resize();
        }
        
        elements[length] = element;
        length++;
    }
    
    /**
     * Returns last element on stack and decrements the stack length (used as an internal pointer).
     * 
     * @return E
     */
    public E pop()
    {
        E element = peek();         
        length--;
        
        return element;
    }
    
    /**
     * Returns last element on the stack.
     * 
     * @return E
     */
    public E peek()
    {
        if (length == 0) {
            return null;
        }
        
        E element = elements[length-1];
        
        return element;
    }

    /**
     * Returns the index of the desired element. 
     * 
     * @param E element
     * @return int
     */
    public int search(E element)
    {        
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Returns the stack size.
     * 
     * @return int
     */
    public int size()
    {
        return length;
    }
    
    /**
     * Checks whether the stack is empty.
     * 
     * @return boolean
     */
    public boolean empty()
    {
        return length == 0;
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
     * @return String
     */
    public String toString()
    {
        return Arrays.toString(elements);
    }
}

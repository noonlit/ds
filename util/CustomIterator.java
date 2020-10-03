package util;

import java.util.Iterator;

public class CustomIterator<E> implements Iterator<E>
{
    private E[] elements;
    private int current = 0;
    private int length;
    
    public CustomIterator(E[] elements, int length)
    {
        this.elements = elements;
        this.length = length;
    }

    @Override
    public boolean hasNext()
    {
        return current < length;
    }

    @Override
    public E next()
    {
        if (current >= length) {
            return null;
        }
        
        E element = elements[current];
        current++;
        
        return element;
    }

}

package util;

/**
 * Based on Pluralsight - Implementing and Understanding Data Structures in Java
 * 
 * See also: 
 * https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
 *  
 * @param <E>
 */
public class BasicStack<E> implements StackInterface<E>
{
    private E data[];
    private int stackPointer = 0;
    
    @SuppressWarnings("unchecked")
    public BasicStack()
    {
        data = (E[]) new Object[1000];
    }
    
    @Override
    public void push(E element)
    {
        data[stackPointer] = element;
        stackPointer++;     
    }
    
    @Override
    public E pop()
    {
        if (stackPointer == 0) {
            return null;
        }
        
        E element = data[stackPointer];
        stackPointer--;
        
        return element;
    }
    
    @Override
    public boolean contains(E element)
    {
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public E access(int position)
    {
        while (stackPointer > 0) {
            E tmp = pop();
            
            if (tmp.equals(data[position])) {
                return tmp;
            }
            
            stackPointer--;
        }
        
        return null;
    }
    
    @Override
    public int size()
    {
        return stackPointer;
    }
}

package homework;

import java.util.Stack;

public class TwoStackQueueV2<E>
{
    private Stack<E> stack;
     
    public TwoStackQueueV2() 
    {
        stack = new Stack<E>();
    }
     
    public void enqueue(E e)
    {
        stack.push(e);
    }
     
    public E dequeue()
    {
        if(stack.isEmpty()) {
            return null;
        }
         
        /*
         * Move all elements to auxiliary stack.
         */
        Stack<E> tmp = new Stack<E>();
        while (!stack.isEmpty()) {
            E element = stack.pop();
            tmp.push(element);
        }
        
        /*
         * First queue element is by definition last element to have been put on the original stack.
         */
        E result = tmp.pop();
        
        /*
         * Move new elements from auxiliary stack to original stack.
         */
        while(!tmp.isEmpty()) {
            E element = tmp.pop();
            stack.push(element);
        }
        
        return result;
    }
     
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
}
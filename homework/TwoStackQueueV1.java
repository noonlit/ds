package homework;

import java.util.Stack;

public class TwoStackQueueV1<E>
{
    private Stack<E> stack;
     
    public TwoStackQueueV1() 
    {
        stack = new Stack<E>();
    }
     
    public void enqueue(E e)
    {
        if(stack.isEmpty()) {
            stack.push(e);
            return;
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
         * Add new element to auxiliary stack.
         */
        stack.push(e);
        
        /*
         * Move new elements from auxiliary stack to original stack.
         */
        while(!tmp.isEmpty()) {
            E element = tmp.pop();
            stack.push(element);
        }
    }
     
    public E dequeue()
    {
        return stack.pop();
    }
     
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
}
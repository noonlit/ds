package class_examples;

import java.util.Stack;

/**
 * Wrapper over a stack. 
 * Keeps a secondary stack of max values synced with the original stack to return stack maximum in O(1).
 */
public class MaxStack
{
    private Stack<Integer> maxElements;
    private Stack<Integer> values;
    
    public MaxStack()
    {
        this.maxElements = new Stack<Integer>();
        this.values = new Stack<Integer>();
    }
    
    public MaxStack(Stack<Integer> stack) {
        this.maxElements = stack;
        this.values = new Stack<Integer>();
    }
    
    public boolean isEmpty()
    {
        return values.isEmpty();
    }
    
    public Integer peek()
    {
        return values.peek();
    }
    
    public Integer getMax()
    {
        return maxElements.peek();
    }
    
    public Integer pop()
    {
        maxElements.pop();
        
        return values.pop();
    }
    
    public Integer push(Integer item)
    {
        Integer currentMax = item;
        if (!maxElements.isEmpty()) {
            currentMax = maxElements.peek();
        }
        
        if (currentMax >= item) {
            maxElements.push(currentMax);
        } else {
            maxElements.push(item);
        }
        
        return values.push(item);
    }
}

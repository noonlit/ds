package util;
import java.util.HashMap;
import java.util.Map;

public class CustomBag<E>
{    
    private Map<E, Integer> elements;
    
    public int size()
    {
        return elements.size();
    }
    
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }
    
    public void add(E element)
    { 
        if (elements == null) {
            elements = new HashMap<E, Integer>();
        }
        
        if (elements.isEmpty() || !elements.containsKey(element)) {
            elements.put(element, 1);
        }
        
        Integer existingValue = elements.get(element);
        elements.put(element, existingValue+1);
    }
    
    public void remove(E element)
    {
        elements.remove(element);
    }
    
    public void decrement(E element)
    {
        if (!elements.containsKey(element)) {
            return;
        }
        
        elements.put(element, elements.get(element) - 1);
    }
    
    /**
     * TODO: finish this. you get the point.
     */
    
    public String toString()
    {
        return elements.toString();
    }
}

package util;

import java.util.Arrays;

public class CustomBagV2 implements Iterable<Pair>
{
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int length = 0;
    
    private Pair elements[];
    
    public CustomBagV2()
    {
        elements = new Pair[DEFAULT_CAPACITY];
    }

    public CustomBagV2(int capacity)
    {
        elements = new Pair[capacity];
        this.capacity = capacity;
    }
    
    /**
     * Returns the size of the internal array.
     * 
     * @return int
     */
    public int size()
    {
        return length;
    }
    
    /**
     * Checks whether the internal array has elements.
     * 
     * @return int
     */
    public boolean isEmpty()
    {
        return length == 0;
    }
    
    /**
     * Adds the item with the given name.
     * 
     * @param string
     * @return void
     */
    public void add(String name) // e.g. bread
    {
        /*
         * Is the item already in the bag? :)
         */
        Pair existingPair = getItem(name);
        
        if (existingPair != null) {
            existingPair.setValue(existingPair.getValue() + 1);
            return;
        }
        
        /*
         * Ensure we have space for the element
         */
        if (length == elements.length) {
            resize();
        }
        
        elements[length] = new Pair(name, 1);
        length++;
    }
    
    /**
     * Removes the item with the given name.
     * 
     * @param string
     * @return void
     */
    public void removeAll(String name) // e.g. bread
    {
        Pair toRemove = getItem(name);
        
        if (toRemove == null) {
            return;
        }
              
        Pair[] copy = new Pair[capacity];

        int index = 0;
        for (int i = 0; i < length; i++) {
            Pair current = elements[i];
            
            if (current.getKey().equals(toRemove.getKey())) {
                continue;
            }

            copy[index] = current;
            index++;
        }

        elements = copy;
        length--;
    }
    
    /**
     * Decrements the count of the item with the given name.
     * 
     * @param string
     * @return void
     */
    public void remove(String name) // e.g. bread
    {
        Pair toDecrement = getItem(name);
        
        if (toDecrement == null) {
            return;
        }
        
        for (int i = 0; i < length; i++) {
            Pair current = elements[i];
            
            if (current.getKey().equals(toDecrement.getKey())) {
                int decrementedValue = toDecrement.getValue() - 1;
                
                if (decrementedValue == 0) {
                    removeAll(name);
                    return;
                }
                
                toDecrement.setValue(decrementedValue);
                continue;
            }
        }
    }
    
    /**
     * Returns the pair that has the given key, null if the pair cannot be found.
     * 
     * @return Pair
     */
    public Pair getItem(String key)
    {
        for (int i = 0; i < length; i++) {
            Pair currentPair = elements[i];
            
            if (currentPair.getKey().equals(key)) {
                return currentPair;
            }         
        }
        
        return null;
    }
    
    /**
     * Returns the count for the item with the given name.
     * 
     * @param String key
     * @return
     */
    public Integer getCountForItem(String key)
    {
        Pair item = getItem(key);
        
        if (item == null) {
            return 0;
        }
        
        return item.getValue();
    }
    
    /**
     * Doubles the capacity of the internal elements array.
     */
    private void resize()
    {
        int capacity = this.capacity * 2;
        elements = Arrays.copyOf(elements, capacity);
        
        this.capacity = capacity;
    }    
    
    /**
     * Returns a string representation of the bag.
     */
    public String toString()
    {
        return Arrays.toString(elements);
    }

    @Override
    public CustomIterator<Pair> iterator()
    {
        return new CustomIterator<Pair>(elements, length);
    }
}
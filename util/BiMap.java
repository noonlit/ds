package util;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.cs.ubbcluj.ro/~marianzsu/Postuniv/Lab/Lab5_probleme.pdf
 */
public class BiMap
{
    /**
     * key => value pairs
     */
    Map<String, String> keyValue;
    
    /**
     * value => key pairs
     */
    Map<String, String> valueKey;
    
    public BiMap()
    {
        keyValue = new HashMap<String, String>();
        valueKey = new HashMap<String, String>();
    }
    
    /**
     * Adds key => value pair.
     * 
     * Both the key and the value are expected to be unique.
     * If they aren't, uniqueness will be enforced :)
     * 
     * @param String key
     * @param String value
     */
    public void add(String key, String value)
    {
        if (!keyValue.containsKey(key) && !valueKey.containsValue(value)) {
            keyValue.put(key, value);
            valueKey.put(value, key);
            return;
        }
        
        String currentValueForKey = keyValue.get(key); 
        String currentKeyForValue = valueKey.get(value);
       
        keyValue.remove(key);
        valueKey.remove(currentValueForKey);
        valueKey.remove(value);
        keyValue.remove(currentKeyForValue);
        
        keyValue.put(key, value);
        valueKey.put(value, key);
    }
    
    /**
     * Removes the key => value pairs in the map based on the given key.
     * 
     * @param String key
     * @return String
     */
    public String delete(String key)
    {      
        valueKey.remove(keyValue.get(key));
        return keyValue.remove(key);
    }
    
    /**
     * Returns the value for the given key.
     * 
     * @param String key
     * @return String
     */
    public String search(String key) 
    {
        return keyValue.get(key);
    }
    
    /**
     * Returns the key for the given value.
     * 
     * @param String value
     * @return String
     */
    public String inverseSearch(String value)
    {
        return valueKey.get(value);
    }
    
    /**
     * Returns the size of the map.
     * 
     * @return int
     */
    public int size()
    {
        return keyValue.size();
    }
    
    /**
     * Returns a string representation of the map.
     * 
     * @return String
     */
    public String toString()
    {
        return "Keys: " + keyValue.toString() + " Values: " + valueKey.toString();
    }
}


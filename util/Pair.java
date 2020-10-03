package util;

public class Pair 
{   
    private Object key;
    private int value;
    
    public Pair(Object key, int value) {
        this.key = key;
        this.value = value;
    }
    
    public Object getKey()
    {
        return key;
    }

    public int getValue()
    {
        return value;
    }
    
    public void setValue(Integer value)
    {
        this.value = value;
    }
    
    public boolean equals(Pair pair)
    {
        return key == pair.getKey() && value == pair.getValue();
    }
    
    public String toString()
    {
        return key + " => " + value;
    }
}

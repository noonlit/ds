package util;

public interface StackInterface<E>
{
    public void push(E element);
    
    public E pop();
    
    public boolean contains(E element);
    
    public E access(int position);
    
    public int size();
}

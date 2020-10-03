package util;

public interface QueueInterface<E>
{
    public void enqueue(E element);
    
    public E dequeue();
    
    public boolean contains(E element);
    
    public E access(int position);
    
    public int size();
}

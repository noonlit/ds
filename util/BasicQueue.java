package util;

public class BasicQueue<E> implements QueueInterface<E>
{
    private E[] data;
    
    private int front = -1;
    private int rear = -1;

    public BasicQueue()
    {
        this(1000);
    }
    
    @SuppressWarnings("unchecked")
    public BasicQueue(int size)
    {
        this.data = (E[]) new Object[size];
    }
    
    @Override
    public void enqueue(E element)
    {
        if ((rear + 1) % data.length == 0) {
            throw new IllegalStateException("The queue is full!");
        }
        
        data[rear] = element;
        rear++;
        
        if (size() == 0) {
            front++;
        }
    }

    @Override
    public E dequeue()
    {
        if (size() == 0) {
            throw new IllegalStateException("The queue is empty!");
        }
        
        E element = data[front]; 
        
        if (front == rear) {
            front = -1;
            rear = -1;
            
            return element;
        }
        
        front++;
        return element;
    }

    @Override
    public boolean contains(E element)
    {
        if (size() == 0) {
            throw new IllegalStateException("The queue is empty!");
        }
        
        for (int i = 0, n = data.length; i < n; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public E access(int position)
    {
        if (size() == 0 || position >= size()) {
            return null;
        }
        
        while (size() != 0) {
            E elem = dequeue();
            
            if (elem == data[position]) {
                return elem;
            }
        }

        return null;
    }
    
    public boolean isEmpty()
    {
        return rear - front < 0;
    }

    @Override
    public int size()
    {
        if (isEmpty()) {
            return 0;
        }
        
        return rear - front + 1;
    }
}

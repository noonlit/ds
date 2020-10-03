package util;

/**
 * Queue represented on a linked list.
 * @param <T>
 */
public class LinkedListQueueV2<T>
{
    /**
     * First node in the queue.
     */
    private Node<T> first;
    
    /**
     * Last node in the queue.
     */
    private Node<T> last;
    
    /**
     * Queue length.
     */
    private int length = 0;

    /**
     * Queue element.
     * 
     * @param <E>
     */
    private class Node<E>
    {
        E data;
        Node<E> next;

        Node(E e)
        {
            this.data = e;
            this.next = null;
        }      
        
        public E getData()
        {
            return data;
        }
        
        public Node<E> getNext() 
        {
            return this.next;
        }
        
        public void setNext(Node<E> node) 
        {
            this.next = node;
        }
    }
    
    /**
     * Adds an element to the queue.
     * 
     * @param value
     */
    public void enqueue(T value) 
    {
        Node<T> newNode = new Node<T>(value);
        
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            length++;
            
            return;
        }
        
        last.setNext(newNode);
        last = newNode;

        length++;
    }
    
    /**
     * Returns the element at the head of the queue.
     * 
     * @return T
     */
    public T dequeue() 
    {
        if (isEmpty()) {
            return null;
        }
             
        Node<T> currentFirst = first;
        first = first.getNext();
        length--;
        
        return currentFirst.getData();
    }
    
    /**
     * Checks whether the queue is empty.
     * 
     * @return boolean.
     */
    public boolean isEmpty()
    {
        return first == null;
    }
    
    /**
     * Returns the length (size) of the queue.
     * 
     * @return int
     */
    public int getLength()
    {
        return length;
    }
    
    /**
     * Returns a string representation of the queue.
     * 
     * @return String
     */
    public String toString()
    {
        String output = ""; 
        
        Node<T> current = first;
        output += first.getData();
        
        while (current.getNext() != null) {
            output += " " + current.getNext().getData();
            current = current.getNext();
        }
        
        return output;
    }

    /**
     * For testing purposes.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        LinkedListQueueV2<Integer> list = new LinkedListQueueV2<Integer>();
        
        list.enqueue(1); 
        list.enqueue(2); 
        list.enqueue(3); 
        list.enqueue(4); 
        list.enqueue(5); 
        list.enqueue(6); 
        
        System.out.println("List contains: " + list);     
        System.out.println("Length is " + list.getLength());
        
        System.out.println("We've dequeued " + list.dequeue());
        System.out.println("We've dequeued " + list.dequeue());
        System.out.println("We've dequeued " + list.dequeue());
        
        System.out.println("List contains: " + list);  
        System.out.println("Length is " + list.getLength());
    }
}


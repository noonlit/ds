package exam;

/**
 * Represent a Bag of Strings on a singly linked list.
 * 
 * Implement constructor.
 * Implement add(e).
 * Implement toString() (for debug purposes).
 */
public class BagSinglyLinkedList
{
    /**
     * @var Node
     */
    private Node first;

    /**
     * Linked list nodes.
     */
    private class Node
    {
        String value;
        Node next;
        Integer frequency;

        Node(String e)
        {
            value = e;
            next = null;
            
            /*
             * A new node appears once.
             */
            frequency = 1;
        }
    }
    
    /**
     * Constructor.
     */
    public BagSinglyLinkedList()
    {
        first = null;
    }
    
    /**
     * Adds value / updates frequency.
     * @param value
     */
    public void add(String value) { 
        /*
         * If the collection is empty, this will be the first element.
         */
        if (first == null) {
            first = new Node(value);
            return;
        }
        
        Node current = first;
        Node previous = null;
        while (current != null) {
            if (current.value == value) {
                current.frequency++;
                return;
            }
            previous = current;
            current = current.next;
        }
        
        /*
         * We haven't found the value and the current is null.
         * Add a new node to the previous one.
         */
         previous.next = new Node(value);
    }
    
    public String toString()
    {
        Node current = first;
        String result = "";
        
        while (current != null) {
            result += "'" + current.value + "' apare de " + current.frequency + " ori \n";
            current = current.next;
        }
        
        return result;
    }
    
    /**
     * Driver code.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        BagSinglyLinkedList bag = new BagSinglyLinkedList();
        bag.add("pisica");
        bag.add("pisica");
        bag.add("pisica");
        bag.add("motan");
        bag.add("motan");
        bag.add("varza");
        bag.add("pisica");
        bag.add("varza");
        
        System.out.println(bag);      
    }
}

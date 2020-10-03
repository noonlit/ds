package util;

public class CustomDoublyLinkedList<T>
{
    /**
     * First node in the list.
     */
    private Node<T> first;

    /**
     * Last node in the list.
     */
    private Node<T> last;

    /*
     * Length of the list.
     */
    private int length;

    /**
     * List element.
     * 
     * @param <E>
     */
    private class Node<E>
    {
        E data;
        Node<E> next;
        Node<E> previous;

        Node(E e)
        {
            this.data = e;
            this.next = null;
            this.previous = null;
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

        public Node<E> getPrevious()
        {
            return this.previous;
        }

        public void setPrevious(Node<E> node)
        {
            this.previous = node;
        }
    }

    public CustomDoublyLinkedList()
    {
        first = null;
        last = null;
        length = 0;
    }

    public void add(T value)
    {
        Node<T> newNode = new Node<T>(value);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
            length++;

            return;
        }

        last.setNext(newNode);
        newNode.setPrevious(last);
        last = newNode;
        length++;
    }

    /**
     * Adds element on the given position.
     * 
     * @param int position
     * @param T   value
     */
    public void add(int position, T value)
    {
        if (position < 0 || position > length - 1) {
            return; // throw
        }

        Node<T> newNode = new Node<T>(value);

        /*
         * Retrieve the node currently found on the given position.
         */
        Node<T> current = first;
        for (int i = 1; i <= position; i++) {
            current = current.getNext();
        }

        /*
         * Ensure we don't lose track of first/last.
         */
        if (current.equals(first)) {
            first = newNode;
        }

        if (current.equals(last)) {
            last = newNode;
        }

        /*
         * Update nodes' previous/next references.
         */
        Node<T> previous = current.getPrevious();
        if (previous != null) {
            previous.setNext(newNode);
        }

        newNode.setPrevious(previous);
        newNode.setNext(current);

        current.setPrevious(newNode);

        length++;
    }

    /**
     * Removes element on given position.
     * 
     * @param int position
     */
    public Node<T> remove(int position)
    {
        /*
         * Nothing to remove if the list is empty.
         */
        if (isEmpty()) {
            return null;
        }
        
        if (position < 0 || position > length - 1) {
            return null; // throw
        }

        /*
         * Find the node on the given position.
         */
        Node<T> current = first;

        for (int i = 1; i <= position; i++) {
            current = current.getNext();
        }

        Node<T> previous = current.getPrevious();
        Node<T> next = current.getNext();

        /*
         * Ensure we don't lose track of first/last.
         */
        if (current.equals(first)) {
            first = next;
        }

        if (current.equals(last)) {
            last = previous;
        }

        /*
         * Update nodes' previous/next references.
         */
        if (previous != null) {
            previous.setNext(next);
        }

        if (next != null) {
            next.setPrevious(previous);
        }

        length--;
        return current;
    }

    /**
     * Checks whether the list is empty.
     * 
     * @return boolean
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * Removes last node in the list.
     * 
     * @return Node<T>
     */
    public Node<T> remove()
    {
        if (isEmpty()) {
            return null;
        }

        Node<T> currentLast = last;

        last = last.getPrevious();
        last.setNext(null);

        return currentLast;
    }

    public void removeByValue(T value)
    {
        /*
         * Nothing to remove if the list is empty.
         */
        if (isEmpty()) {
            return;
        }

        /*
         * Find the node with the given value
         */
        boolean found = false;
        Node<T> current = first;
        while (current != null) {
            if (value == current.getData()) {
                found = true;
                break;
            }

            current = current.getNext();
        }

        if (!found) {
            return;
        }

        Node<T> previous = current.getPrevious();
        Node<T> next = current.getNext();

        /*
         * Ensure we don't lose track of first/last.
         */
        if (current.equals(first)) {
            first = next;
        }

        if (current.equals(last)) {
            last = previous;
        }

        /*
         * Update nodes' previous/next references.
         */
        if (previous != null) {
            previous.setNext(next);
        }

        if (next != null) {
            next.setPrevious(previous);
        }

        length--;
    }

    /**
     * Returns a string representation of the list.
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

    public static void main(String[] args)
    {
        CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<Integer>();

        list.add(1);
        list.remove(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);

        System.out.println("Adding 9 on position 0 ...");
        list.add(0, 9);

        System.out.println("Adding 8 on position 1 ... ");
        list.add(1, 8);

        System.out.println("Adding 7 on position 3 ... ");
        list.add(3, 7);

        System.out.println(list);

        System.out.println("Removing element on position 1: ");
        list.remove(1);
        System.out.println(list);

        System.out.println("Removing element on position 0: ");
        list.remove(0);
        System.out.println(list);

        System.out.println("Removing element on last position: ");
        list.remove(list.length - 1);
        System.out.println(list);

        System.out.println("Removing last element: ");
        list.remove();
        System.out.println(list);

        System.out.println("Removing last element: ");
        list.remove();
        System.out.println(list);

        System.out.println("Testing bounds...");
        list.add(1000, 1000);
        list.remove(2000);
        System.out.println(list);

        System.out.println("Testing remove by value ...");
        list.removeByValue(3);
        list.removeByValue(1000000);
        System.out.println(list);
    }
}

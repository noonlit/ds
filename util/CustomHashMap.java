package util;

/**
 * Implement search, add
 * 
 * Strategy -> independent/chained lists
 * 
 * Must implement function to give position in array
 */
public class CustomHashMap
{
    Node[] elements;
    int capacity;
    int size;
    
    private class Node
    {
        int key;
        String value;
        Node next;

        public Node(int k, String v)
        {
            key = k;
            value = v;
            next = null;
        }
    }
    
    CustomHashMap() {
        capacity = 10;
        size = 0;
        elements = new Node[capacity];
    }
    
    public Integer hash(int key) {
        return key % capacity;
    }
    
    public void put(int key, String value) 
    {
        /*
         * Find place to add element.
         */
        int hashKey = hash(key);
        Node newNode = new Node(key, value);
        Node currentNode = elements[hashKey];
        
        /*
         * First element, yay 
         */       
        if (currentNode == null) {
            elements[hashKey] = newNode;
            size++;
            return;
        }
        
        /*
         * The calculated position contains at least one node.
         */       
        while (currentNode.next != null) {
            if (currentNode.key == key) {
                return;
            }
            
            currentNode = currentNode.next;
        }
        
        /*
         * Add new node to last position.
         */
        currentNode.next = newNode; 
        size++;
    }
    
    public void delete(int key)
    {
        int hashKey = hash(key);
        Node currentNode = elements[hashKey];
        
        if (currentNode == null) {
            return;
        }
        
        if (currentNode.key == key) {
            elements[hashKey] = null;
            return;
        }
        
        while (currentNode.next != null) {
            if (currentNode.next.key == key) {
                currentNode.next = null;
                return;
            }
            
            currentNode = currentNode.next;
        }
    }
   
    public boolean containsValue(String value)
    {
        for (int i = 0; i < capacity; i++) {
            Node currentNode = elements[i];
            if (currentNode == null) {
                continue;
            }
            
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
                
                currentNode = currentNode.next;
            }
        }
      
        return false;
    }
    
    public boolean containsKey(int key)
    {
        int hashKey = hash(key);
        Node currentNode = elements[hashKey];
        
        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            
            currentNode = currentNode.next;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMap();
        hashMap.put(1, "element 1");
        hashMap.put(3, "element 3");
        
        /*
         * Test duplicates
         */
        hashMap.put(3, "element 3+1");
        hashMap.put(3, "element 3+2");
        
        /*
         * Test new item 
         */     
        hashMap.put(13, "element 13");
        
        System.out.println(hashMap.containsKey(13));
        System.out.println(hashMap.containsKey(1)); 
        System.out.println(hashMap.containsKey(3)); 
        System.out.println(hashMap.containsValue("element 13"));
        System.out.println();
        
        System.out.println(hashMap.containsKey(16));
        System.out.println(hashMap.containsValue("bla"));
        System.out.println();
        
        hashMap.delete(13);
        System.out.println(hashMap.containsKey(13)); 
        hashMap.delete(3);
        System.out.println(hashMap.containsKey(3));
    }
}

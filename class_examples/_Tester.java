package class_examples;

import util.BiMap;
import util.CustomBag;
import util.CustomBagV2;
import util.CustomIterator;
import util.CustomStack;
import util.Pair;

public class _Tester
{
    public static void main(String[] args)
    {
        // testStack();
        // testDynamicArray();
        // testCustomBag();
        
         //testCustomBagV2();
         //testIterator();
        
        testBidirectionalDictionary();
    }
    
    private static void testBidirectionalDictionary()
    {
        BiMap dict = new BiMap();
        
        /*
         * Test unique key-values
         */
        dict.add("a", "b");
        dict.add("c", "d");
        
        /*
         * Adding a and d should result in this being the only pair in the structure
         * because both the key and the value exist
         */
        System.out.println(dict);
        dict.add("a", "d");
        System.out.println(dict);
        
        /*
         * Test add and delete.
         */
        dict.add("f", "g");
        dict.add("w", "t");      
        String deleted = dict.delete("w");
        System.out.println("Deleted: " + deleted);
        deleted = dict.delete("q");
        System.out.println("Deleted: " + deleted);
      
        /*
         * Test search.
         */
        System.out.println("Value for a: " + dict.search("a"));
        System.out.println("Key for g: " + dict.inverseSearch("g"));
        
        System.out.println(dict);
    }
    
    private static void testIterator()
    {
        Integer[] a = new Integer[10];
        a[0] = 1;
        a[1] = 21;
        a[2] = 3;
        CustomIterator<Integer> iterator = new CustomIterator<Integer>(a, 3);
        System.out.println("Test iterator:");
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    private static void testCustomBagV2()
    {
        CustomBagV2 bag = new CustomBagV2(5);
        
        bag.add("bread");       
        System.out.println(bag.toString());
        
        System.out.println(bag.getCountForItem("bread"));
        System.out.println(bag.getCountForItem("wine"));
        
        bag.add("pretzels");
        bag.add("apple");
        bag.add("apple");
        bag.add("apple");
        System.out.println(bag.toString());
        
        bag.remove("apple");
        bag.remove("apple");
        System.out.println(bag.toString());
        
        bag.remove("apple");
        System.out.println(bag.toString());  
        
        CustomIterator<Pair> iterator = bag.iterator();
        
        System.out.println("Test iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    private static void testCustomBag()
    {
        CustomBag<String> bag = new CustomBag<String>();
        bag.add("bread");
        bag.add("milk");
        
        bag.remove("milk");
        
        System.out.println(bag.toString());
    }
    
    
    private static void testStack()
    {
        CustomStack<Integer> stack = new CustomStack<Integer>(3);
        stack.push(10);
        stack.push(3);
        stack.push(11);
        
        System.out.println(stack.toString());
        System.out.println("Size: " + stack.size());
        
        int last = stack.pop();
        System.out.println("Last is: " + last);
        System.out.println("Size: " + stack.size());
        
        last = stack.peek();
        System.out.println("Last is: " + last);
        System.out.println("Size: " + stack.size());
        
        int searched = stack.search(last);
        System.out.println("Index of searched element is: " + searched);
    }

    private static void testDynamicArray()
    {
        DynamicArray<Integer> array = new DynamicArray<Integer>(5);

        /*
         * Test add() + addAt()
         */
        array.add(19);
        array.add(10);
        array.addAt(0, 4);
        System.out.println(array.toString());

        /*
         * Test getAt()
         */
        System.out.println(array.getAt(1));

        /*
         * Test removeAt()
         */
        array.removeAt(2);
        System.out.println(array.toString());

        /*
         * Test add() + resize()
         */
        array.add(16);
        array.add(12);
        array.add(30);
        array.add(79);
        array.add(20);
        array.add(11);
        array.add(93);
        array.addAt(7, 13);
        System.out.println(array.toString());

        /*
         * Test exceptions
         */
        try {
            array.addAt(150, 150);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            array.removeAt(170);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Iteration version A:");
//        while (array.hasNext()) {
//            System.out.println(array.next());
//        }
        
        System.out.println("Iteration version B:");
        for (Integer current : array) {
            System.out.println(current);
        }
    }
}

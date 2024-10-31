/*
 * LinkedListReplicated.java
 * Shawn Ray
 * Period 4
 * November 30, 2023
 * This file tests LinkedIntList.java
 */


public class LinkedListReplicated  {
 
    public static void main(String s[]) 
    {
        //Students create 2 LinkedIntList objects.
        // a) Uses the default constructor
        LinkedIntList list1 = new LinkedIntList();
        
        // b) Uses the the construtor that allows an integer value to be passed in.
        LinkedIntList list2 = new LinkedIntList(10);
    	
        //Test out each of your various methods (add, insert, get, indexOf, remove, size, toString)) 
        //using either of the instantiated LinkedIntList objects

        // Testing add method
        list1.add(5);
        list1.add(10);
        list1.add(15);
        System.out.println("List 1 after adding elements: " + list1.toString());

        // Testing add at index method
        list1.add(1, 7);
        System.out.println("List 1 after adding 7 at index 1: " + list1.toString());

        // Testing get method
        System.out.println("Element at index 2 in List 1: " + list1.get(2));

        // Testing indexOf method
        System.out.println("Index of 10 in List 1: " + list1.indexOf(10));

        // Testing remove method
        list1.remove(1);
        System.out.println("List 1 after removing element at index 1: " + list1.toString());

        // Testing size method
        System.out.println("Size of List 1: " + list1.size());

        // Testing clear method
        list1.clear();
        System.out.println("List 1 after clearing: " + list1.toString());

        // Testing sort method
        list2.add(5);
        list2.add(15);
        list2.add(10);
        System.out.println("List 2 before sorting: " + list2.toString());
        list2.sort();
        System.out.println("List 2 after sorting: " + list2.toString());

        // Testing toString method
        list1.add(5);
        System.out.println("List 1: " + list1.toString());
        System.out.println("List 2: " + list2.toString());
    }
    
    //Create your LinkedIntList class in another file called "LinkedIntList"
}

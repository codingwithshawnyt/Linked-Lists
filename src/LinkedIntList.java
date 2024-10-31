/*
 * LinkedIntList.java
 * Shawn Ray
 * Period 4
 * This file effectively recreates the functionality of an Integer Linked List.
 */

// Importing the NoSuchElementException class from java.util package
import java.util.NoSuchElementException;

// Definition of the LinkedIntList class
public class LinkedIntList {
    // Declare a private variable 'front' of type ListNode
    private ListNode front; 

    // Default constructor for the LinkedIntList class
    public LinkedIntList() {
        // Initialize 'front' to null indicating an empty list
        front = null;
    }

    // Constructor for the LinkedIntList class that takes an integer value as parameter
    public LinkedIntList(int value) {
        // Initialize 'front' to a new ListNode with the given value
        front = new ListNode(value);
    }

    // Method to add a value to the end of the list
    public void add(int value) {
        // If the list is empty, create a new ListNode with the given value and assign it to 'front'
        if (front == null) {
            front = new ListNode(value);
        } else {
            // If the list is not empty, traverse to the end of the list
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            // Add a new ListNode with the given value at the end of the list
            current.next = new ListNode(value);
        }
    }

    // Method to insert a value at a given index in the list
    public void add(int index, int value) {
        // If the index is less than 0 or greater than 0 and the list is empty, throw an exception
        if (index < 0 || (index > 0 && front == null)) {
            throw new NoSuchElementException("Invalid index.");
        }
        // If the index is 0, add a new ListNode with the given value at the front of the list
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            // If the index is not 0, traverse to the node before the given index
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                // If the end of the list is reached before the given index, throw an exception
                if (current.next == null) {
                    throw new NoSuchElementException("Invalid index.");
                }
                current = current.next;
            }
            // Insert a new ListNode with the given value at the given index
            current.next = new ListNode(value, current.next);
        }
    }

    // Method to get the value at a given index in the list
    public int get(int index) {
        // If the list is empty, throw an exception
        if (front == null) {
            throw new NoSuchElementException("List is empty.");
        }
        // Traverse to the given index in the list
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            // If the end of the list is reached before the given index, throw an exception
            if (current.next == null) {
                throw new NoSuchElementException("Invalid index.");
            }
            current = current.next;
        }
        // Return the value at the given index
        return current.data;
    }

    // Method to find the index of the first occurrence of a given value in the list
    public int indexOf(int value) {
        // Initialize the index to 0
        int index = 0;
        // Start traversal from the front of the list
        ListNode current = front;
        // Continue traversal until the end of the list is reached
        while (current !=  null) {
            // If the current node's data matches the given value, return the current index
            if (current.data == value) {
                return index;
            }
            // Move to the next node and increment the index
            index++;
            current = current.next;
        }
        // If the given value is not found in the list, return -1
        return -1;  
    }

    // Method to remove the node at a given index from the list and return its value
    public int remove(int index) {
        // If the list is empty, throw an exception
        if (front == null) {
            throw new NoSuchElementException("List is empty.");
        }
        // Declare a variable to hold the value of the removed node
        int removed;
        // If the index is 0, remove the front node
        if (index == 0) {
            // Save the value of the front node
            removed = front.data;
            // Remove the front node by moving the 'front' reference to the next node
            front = front.next;
        } else {
            // If the index is not 0, traverse to the node before the given index
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                // If the end of the list is reached before the given index, throw an exception
                if (current.next == null) {
                    throw new NoSuchElementException("Invalid index.");
                }
                current = current.next;
            }
            // If the given index is the end of the list, throw an exception
            if (current.next == null) {
                throw new NoSuchElementException("Invalid index.");
            }
            // Save the value of the node at the given index
            removed = current.next.data;
            // Remove the node at the given index by skipping it in the list
            current.next = current.next.next;
        }
        // Return the value of the removed node
        return removed;
    }

    // Method to return the current number of elements in the list
    public int size() {
        // Initialize the count to 0
        int count = 0;
        // Start traversal from the front of the list
        ListNode current = front;
        // Continue traversal until the end of the list is reached
        while (current != null) {
            // Increment the count for each node
            count++;
            // Move to the next node
            current = current.next;
        }
        // Return the count
        return count;
    }

    // Method to return a comma-separated, bracketed version of the list
    public String toString() {
        // If the list is empty, return "[]"
        if (front == null) {
            return "[]";
        } else {
            // If the list is not empty, start building the string with the front node's data
            String result = "[" + front.data;
            // Start traversal from the second node in the list
            ListNode current = front.next;
            // Continue traversal until the end of the list is reached
            while (current != null) {
                // Append each node's data to the string
                result += ", " + current.data;
                // Move to the next node
                current = current.next;
            }
            // Close the bracket and return the string
            result += "]";
            return result;
        }
    }

    // Method to remove all elements from the list
    public void clear() {
        // Set 'front' to null, effectively clearing the list
        front = null;
    }

    // Method to sort the elements of the list into ascending order
    public void sort() {
        // Simple selection sort
        // Start traversal from the front of the list
        ListNode current = front;
        // Continue traversal until the end of the list is reached
        while (current != null) {
            // Assume the current node is the minimum
            ListNode min = current;
            // Start another traversal from the node after the current node
            ListNode other = current.next;
            // Continue the second traversal until the end of the list is reached
            while (other != null) {
                // If a node with a smaller value is found, update 'min'
                if (other.data < min.data) {
                    min = other;
                }
                // Move to the next node in the second traversal
                other = other.next;
            }
            // Swap the data of the current node and the minimum node
            int temp = current.data;
            current.data = min.data;
            min.data = temp;
            // Move to the next node in the first traversal
            current = current.next;
        }
    }
}

/**
 * @(#)ListNode.java
 */


public class ListNode {

    int data;
    ListNode next;

    public ListNode()
    {
        this(0, null);
    }
    
    public ListNode(int data)
    {
    	this.data = data;
    	this.next = null;
    }
    
    public ListNode(int data, ListNode next)
    {
    	this.data = data;
    	this.next = next;
    }
    
}
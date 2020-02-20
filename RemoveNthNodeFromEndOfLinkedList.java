package Leetcode;

import java.util.List;
import java.util.Queue;

public class RemoveNthNodeFromEndOfLinkedList
{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        if(head==null || head.next==null)
            return null;
        
        while(n-->0)
        {
            fast = fast.next;
        }
        
        ListNode pre = slow;
        while(fast!=null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        pre.next = slow.next;
        
        return head;
    }
    public static void main( String[] args )
    {
        ListNode  head = new ListNode(1);
        head.next = new ListNode(2);
        
        RemoveNthNodeFromEndOfLinkedList obj = new RemoveNthNodeFromEndOfLinkedList();
        obj.removeNthFromEnd( head, 2 ) ;
    }

}

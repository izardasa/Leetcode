package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveDuplicatesFromSortedListII
{

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode pre = head;
        ListNode next = head.next;
        
        while(next!=null)
        {
            while(pre.val==next.val && next!=null)
            {
                next = next.next;
            }
            
            pre.next = next;
            pre = pre.next;
            
            if(next!=null)
            next = next.next;
        }
        
        return head;
    }

    public static void main( String[] args )
    {
        RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();
        ListNode head = new ListNode(1);
        head.next  = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        
        
        obj.deleteDuplicates( head );
    }

}

package Leetcode;

import java.util.HashMap;

public class AddTwoNumbers
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry=0;
        
        while(l1!=null || l2!=null)
        {
            int sum = carry;    
            
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            
            carry = sum/10;
            result.next = new ListNode(sum%10);
            result= result.next;
        }
        
        if(carry>0)
        {
            result.next = new ListNode(carry);
            result= result.next;
        }
        return head.next;
        
        
    }

    public static void main( String[] args )
    {
        ListNode l1= new ListNode(2);
        ListNode l2= new ListNode(4);
        ListNode l3= new ListNode(7);
        ListNode l11= new ListNode(5);
        ListNode l12= new ListNode(6);
        ListNode l13= new ListNode(4);
        
        l1.next = l2;
        l2.next = l3;
        l11.next = l12;
        l12.next =l13;
        ListNode res = addTwoNumbers(l1,l11);
        
        while(res!=null)
        {
            System.out.print( res.val+" ");
            res=res.next;
        }
        
    }

}

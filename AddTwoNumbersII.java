package Leetcode;

import java.util.Stack;

public class AddTwoNumbersII
{
    public static ListNode addTwoNumbers( ListNode l1, ListNode l2 )
    {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        while( l1 != null )
        {
            stack1.push( l1.val );
            l1 = l1.next;
        }

        while( l2 != null )
        {
            stack2.push( l2.val );
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode result = new ListNode( 0 );
        while( !stack1.isEmpty() || !stack2.isEmpty() )
        {
            int num1 = 0;
            int num2 = 0;
            if( !stack1.isEmpty() )
            {
                num1 = stack1.pop();
            }
            if( !stack2.isEmpty() )
            {
                num2 = stack2.pop();
            }

            sum = num1 + num2 + carry;
            ListNode newNode = new ListNode( sum % 10 );
            newNode.next = result.next;
            result.next = newNode;
            carry = sum / 10;
        }

        if( carry > 0 )
        {
            ListNode newNode = new ListNode( carry );
            newNode.next = result.next;
            result.next = newNode;
        }

        return result.next;
    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 2 );//2-4-7
        ListNode l2 = new ListNode( 4 );//5-6-4
        ListNode l3 = new ListNode( 7 );
        ListNode l11 = new ListNode( 5 );
        ListNode l12 = new ListNode( 6 );
        ListNode l13 = new ListNode( 4 );

        l1.next = l2;
        l2.next = l3;
        l11.next = l12;
        l12.next = l13;
        ListNode res = addTwoNumbers( l1, l11 );

        while( res != null )
        {
            System.out.print( res.val + " " );
            res = res.next;
        }

    }

}

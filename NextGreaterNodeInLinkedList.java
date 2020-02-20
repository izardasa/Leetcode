package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class ListNode
{
    int val;
    ListNode next;

    ListNode( int x )
    {
        val = x;
    }
}

public class NextGreaterNodeInLinkedList
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        ListNode temp = new ListNode( 0 );
        ListNode head = temp;
        for( int i = 0; i < n; i++ )
        {
            temp.next = new ListNode( s.nextInt() );
            temp = temp.next;
        }
        head = head.next;

        int[] nextLargerNodes = nextLargerNodes(head);
        for(int nextNumber: nextLargerNodes)
            System.out.print( nextNumber + " ");
    }

    public static int[] nextLargerNodes( ListNode head )
    {
        ArrayList<Integer> list = new ArrayList();
        
        while(head!=null)
        {
            list.add( head.val );
            head= head.next;
        }
        
        int n = list.size();
        int[] res = new int[n];
        Arrays.fill( res, 0 );
        Stack<Integer> stack = new Stack();
        for(int i =0;i<n;i++)
        {
            while(!stack.isEmpty() && list.get( stack.peek())<list.get( i ))
            {
                res[stack.pop()] = list.get( i );
            }
            
            stack.push( i );
        }
        return res;
    }
}

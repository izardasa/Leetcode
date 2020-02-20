package Leetcode;

class PalindromeLinkedList
{
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast==null || fast.next==null)
            return true;
        if(fast.next.next==null && fast.val==fast.next.val)
            return true;
        
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode reversedList = reverseList(slow.next);
        
        while(reversedList!=null)
        {
            if(head.val!=reversedList.val)
                return false;
            
            head = head.next;
            reversedList = reversedList.next;
               
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode head)
    {
        if(head==null)
            return head;
        
        ListNode c1= head;
        ListNode temp = null;
        while(c1!=null)
        {
            ListNode c2= c1.next;
            c1.next = temp;
            temp = c1;
            c1=c2;
        }
        
        return temp;
    }
    public static void main( String[] args )
    {
        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode n1= new ListNode( 1 );
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(2);
        n1.next.next.next = new ListNode(1);
        System.out.println( obj.isPalindrome( n1 ) );

    }
}

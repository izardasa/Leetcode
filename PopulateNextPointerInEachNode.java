package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextPointerInEachNode
{
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect( Node root )
    {
        if( root == null )
            return null;
        Queue<Node> q = new LinkedList();
        q.add( root );
        while( !q.isEmpty() )
        {
            Node temp = q.poll();
            if( temp.left != null )
            {
                if( temp.right != null )
                {
                    temp.left.next = temp.right;
                }
                q.add( temp.left );
            }

            if( temp.right != null )
            {
                if( temp.next != null && temp.next.left != null )
                {
                    temp.right.next = temp.next.left;
                }
                else if( temp.next != null && temp.next.right != null )
                {
                    temp.right.next = temp.next.right;
                }

                q.add( temp.right );
            }
        }

        return root;
    }


    public static void main( String[] args )
    {
        PopulateNextPointerInEachNode obj = new PopulateNextPointerInEachNode();
        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);
        

        Node connect = obj.connect( root );

      
    }

}

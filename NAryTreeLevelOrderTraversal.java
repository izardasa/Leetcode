package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node
{
    public int val;
    public List<Node> children;

    public Node()
    {
    }

    public Node( int _val )
    {
        val = _val;
    }

    public Node( int _val, List<Node> _children )
    {
        val = _val;
        children = _children;
    }
};

public class NAryTreeLevelOrderTraversal
{
    public static void main( String[] args )
    {

        List<Node> children = new ArrayList();
        children.add( new Node( 3 ) );
        children.add( new Node( 2 ) );
        children.add( new Node( 4 ) );
        Node root = new Node( 1, children );

        NAryTreeLevelOrderTraversal nary = new NAryTreeLevelOrderTraversal();
        List<List<Integer>> levelOrderResult = nary.levelOrder( root );
        System.out.println( levelOrderResult );

    }

    public List<List<Integer>> levelOrder( Node root )
    {
        List<List<Integer>> result = new ArrayList();
        LinkedList<Node> q = new LinkedList();
        if( root == null )
            return result;

        q.add( root );
        q.add( null );
        List<Integer> currentResult = new ArrayList();
        while( !q.isEmpty() )
        {
            Node temp = q.removeFirst();

            if( temp != null )
            {

                currentResult.add( temp.val );
                if( temp.children != null )
                {
                    for( Node child : temp.children )
                        q.addLast( child );
                }
            }

            else if( temp == null && !q.isEmpty() )
            {
                result.add( currentResult );
                currentResult = new ArrayList();
                q.addLast( null );
            }
            
            if(q.isEmpty())
                result.add( currentResult );
        }

        return result;
    }
}

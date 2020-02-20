package Leetcode;

import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeABinaryTRee
{
    public static String serialize( TreeNode root )
    {
        String result = "";
        if( root == null )
            return result;

        Queue<TreeNode> q = new java.util.LinkedList<TreeNode>();
        q.add( root );

        while( !q.isEmpty() )
        {
            TreeNode temp = q.remove();

            if( temp != null )
            {
                result += temp.val+",";
                q.add( temp.left );
                q.add( temp.right );
            }
            else
            {
                result += "null,";
            }
        }
        return result;

    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.right.left = new TreeNode( 6 );
        root.right.right = new TreeNode( 7 );
        String result = SerializeAndDeserializeABinaryTRee.serialize( root );
        System.out.println( result );
    }

}

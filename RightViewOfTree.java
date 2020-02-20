package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode( int x )
    {
        val = x;
    }
}

public class RightViewOfTree
{
    public static List<Integer> rightSideView( TreeNode root )
    {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        viewHelper( root, result, map, 0 );
        return result;
    }

    private static void viewHelper( TreeNode root, List<Integer> result, HashMap<Integer, Integer> map, int level )
    {
        if( root == null )
            return;

        if( !map.containsKey( level ) )
        {
            map.put( level, root.val );
            result.add( root.val );
        }
        viewHelper( root.right, result, map, level + 1 );
        viewHelper( root.left, result, map, level + 1 );
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 4 );
        List<Integer> result = RightViewOfTree.rightSideView( root );
        for( Integer number : result )
            System.out.println( number );
    }

}

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;



public class TopViewOfTree
{
    public static List<Integer> topView( TreeNode root )
    {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        viewHelper( root, result, map, 0 );
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b)->a-b);
        for(Integer key: map.keySet())
        {
            minHeap.add(key);
        }
        
        List<Integer> sortedResult = new ArrayList();
        while(!minHeap.isEmpty())
            sortedResult.add(map.get(minHeap.remove()) );
        return sortedResult;
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
        viewHelper( root.left, result, map, level - 1 );
        viewHelper( root.right, result, map, level + 1 );
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result = TopViewOfTree.topView( root );
        for( Integer number : result )
            System.out.println( number );
    }

}

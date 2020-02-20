package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal
{
    private void verticalOrderHelper(TreeNode root, HashMap<Integer, List<Integer>> map, int index, int[] minMaxList)
    {
        if(root==null)
            return;
        
        int min = minMaxList[0];
        int max = minMaxList[1];
        
        if(min>index)
            minMaxList[0] = index;
        
        if(max<index)
            minMaxList[1] = index;
            
        List<Integer> currentResult = map.get(index);
        if(currentResult!=null)
        {
            currentResult.add(root.val);
        }
        else
        {
            currentResult = new ArrayList();
            map.put( index, currentResult );
            currentResult.add(root.val);
        }
        
        verticalOrderHelper(root.left, map, index-1, minMaxList);
        verticalOrderHelper(root.right, map, index+1, minMaxList);
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if(root==null)
            return result;
        
        int[] minMaxList = new int[2];
        
        HashMap<Integer, List<Integer>> map = new HashMap();
        verticalOrderHelper(root, map,0, minMaxList);
        
        for(int i= minMaxList[0];i<=minMaxList[1];i++)
        {
            result.add(map.get(i));
        }
        
        return result;
    }
   
    
    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(5);
        root.left.right.right = new TreeNode(2);
        
        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> result = obj.verticalOrder( root );
        
        for(List<Integer> res : result)
            System.out.println( res );
    }

}

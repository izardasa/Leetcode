package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree
{
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null)
            return result;
        
        while(root!=null)
        {
            List<Integer> temp = new ArrayList();
            root = makeLeavesNull(root, temp);
            result.add(temp);
        }
        return result;
        
    }
    
    private TreeNode makeLeavesNull(TreeNode root, List<Integer> temp)
    {
        if(root==null)
            return root;
        
        boolean nodeAdded = false;
        if(root.left==null && root.right==null)
        {
            temp.add(root.val);
            nodeAdded = true;
        }
            
        root.left = makeLeavesNull(root.left, temp);
        root.right = makeLeavesNull(root.right, temp);
        
        return nodeAdded?null: root;
    }
    public static void main( String[] args )
    {
        FindLeavesOfBinaryTree obj = new FindLeavesOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
       System.out.println( obj.findLeaves( root ) );
    }

}

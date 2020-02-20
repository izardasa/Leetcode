package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal
{

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if(root==null)
            return result;
        
        
        Queue<TreeNode> q = new LinkedList();
        q.add( root );
        q.add(null);
        result.add(new ArrayList());
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            
            if(temp==null && !q.isEmpty())
            {
                result.add(new ArrayList());
                q.add(null);                
            }
            
            if(temp!=null)
            {
                result.get(result.size()-1).add(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
        }
        
        return result;
    }
    
    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = obj.levelOrder( root );
        
        for(List<Integer> res : result)
            System.out.println( res );
    }

}

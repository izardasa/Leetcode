package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesAndReturnForest
{


    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        DeleteNodesAndReturnForest obj = new DeleteNodesAndReturnForest();
        int[] to_delete = new int[] {3,5};
         List<TreeNode> delNodes = obj.delNodes( root, to_delete ) ;
         System.out.println( delNodes );
        
        
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList();
        
        if(root==null)
            return result;
        
        HashSet<Integer> deleteSet = new HashSet();
        for(int num: to_delete)
            deleteSet.add(num);
        
        delNodes(root, result, deleteSet);
        
        if(!deleteSet.contains(root.val))
            result.add(root);
        return result;
    }
    
    private TreeNode delNodes(TreeNode root, List<TreeNode> result,HashSet<Integer> deleteSet)
    {
        if(root==null)
            return null;
        
        root.left = delNodes(root.left, result, deleteSet);
        root.right = delNodes(root.right, result, deleteSet);
        if(deleteSet.contains(root.val))
        {
            if(null!=root.left)
                result.add(root.left);
            if(null!=root.right)
                result.add(root.right);
            
            root=null;
        }
        
        return root;
    }
}

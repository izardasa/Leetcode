package Leetcode;

import java.util.List;
import java.util.Stack;

public class InorderSuccessorInBST
{
    public TreeNode inorderSuccessor( TreeNode root, TreeNode p )
    {
        if(root==null || p==null)
            return null;
        
        if(p.right!=null)
        {
            TreeNode temp = p.right;
            while(temp.left!=null)
            {
                temp= temp.left;
            }
            
            return temp;
        }
        
        Stack<TreeNode> stack = new Stack();
        int inorder = Integer.MIN_VALUE;
        TreeNode temp = root;
        while(temp!=null || !stack.isEmpty())
        {
            while(temp!=null)
            {
                stack.push( temp );
                temp = temp.left;
            }
            
            temp = stack.pop();
            if(inorder==p.val) return temp;
            inorder = temp.val;
            temp= temp.right;
        }
        
        return null;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(2 );
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
  
        InorderSuccessorInBST obj = new InorderSuccessorInBST();
        System.out.println( obj.inorderSuccessor( root, root.left ).val );
    }

}

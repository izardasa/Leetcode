package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversal( TreeNode root )
    {
        List<Integer> result = new ArrayList();
        if( root == null )
            return result;

        Stack<TreeNode> stack = new Stack();
        stack.push( root );

        while( !stack.isEmpty() )
        {
            
            root = root.left;

            if( root != null )
                stack.push( root );
            else
            {
                root = stack.pop();
                result.add( root.val );
                if( root.right != null )
                    stack.push( root.right );

                root = root.right;
            }
        }

        return result;
    }

    public static void main( String[] args )
    {
        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(  obj.inorderTraversal( root ) );
    }

}

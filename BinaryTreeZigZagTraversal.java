package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagTraversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
          
          boolean rightToLeft = false;
          Stack<TreeNode> stack1 = new Stack();
          Stack<TreeNode> stack2 = new Stack();
          stack1.push(root);
          result.add(new ArrayList());
          while(!stack1.isEmpty())
          {
              TreeNode temp = stack1.pop();
              result.get(result.size()-1).add(temp.val);
              if( temp!=null)
              {
                  
                  if(rightToLeft)
                  {
                      if(temp.left!=null)
                          stack2.push(temp.left);
                  
                      if(temp.right!=null)
                          stack2.push(temp.right);
                  }
                  else
                  {
                      if(temp.right!=null)
                          stack2.push(temp.right);
                      if(temp.left!=null)
                          stack2.push(temp.left);
                  }
              }
              
              if(stack1.isEmpty())
              {
                  result.add(new ArrayList());
                  rightToLeft = !rightToLeft;
                  Stack<TreeNode> temp1 = stack2;
                  stack2 = stack1;
                  stack1 = temp1;
              }
          }
          return result;
      }


    public static void main( String[] args )
    {
        BinaryTreeZigZagTraversal obj = new BinaryTreeZigZagTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        

         List<List<Integer>> zigzagLevelOrder = obj.zigzagLevelOrder(  root );

      
    }

}

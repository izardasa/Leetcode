package Leetcode;

public class ConstructBinaryTreeFromPreorderAndInorder
{
    int preIndex=0;
    public static void main( String[] args )
    {
        ConstructBinaryTreeFromPreorderAndInorder obj = new ConstructBinaryTreeFromPreorderAndInorder();
        int[] preorder = new int[] {1,2,4,5,3,6,7};
        int[] inorder = new int[] {4,2,5,1,6,3,7};
        TreeNode buildTree = obj.buildTree( preorder, inorder );
        System.out.println( buildTree );
    }

    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        return buildTreeHelper(preorder, inorder,  0, inorder.length-1);
    }

    private TreeNode buildTreeHelper( int[] preorder, int[] inorder,  int inStart, int inEnd )
    {
        if(preIndex>=preorder.length || inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        
        int inIndex = findInorderIndex(inorder, root.val);
        root.left  = buildTreeHelper( preorder, inorder, inStart, inIndex-1 );
        root.right = buildTreeHelper( preorder, inorder, inIndex+1, inEnd );
        return root;
    }

    private int findInorderIndex(int[] inorder, int val )
    {
        for(int i=0;i<inorder.length;i++)
        {
            if(val==inorder[i])
                return i;
        }
        return -1;
    }

}

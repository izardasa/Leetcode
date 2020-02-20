package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations
{
    public List<List<Integer>> permute( int[] nums )
    {
        List<List<Integer>> result = new ArrayList();

        if( nums == null || nums.length == 0 )
            return result;

        permuteRecursive( nums, result, 0, new ArrayList<Integer>() );
        return result;
    }

    private void permuteRecursive( int[] nums, List<List<Integer>> result, int currentIndex,
        List<Integer> currentResult )
    {
        if( currentIndex == nums.length )
        {
            result.add( currentResult );
            return;
        }

        for( int i = currentIndex; i < nums.length; i++ )
        {
            swap(nums, i, currentIndex);
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            permuteRecursive( nums, result, currentIndex + 1, list );
            swap(nums, currentIndex, i);
        }
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 2 );
        root.left = new TreeNode( 1 );
        root.right = new TreeNode( 3 );

        Permutations obj = new Permutations();
         List<List<Integer>> numsList = obj.permute( new int[] {1,2,3} );
         System.out.println( numsList );
    }

}

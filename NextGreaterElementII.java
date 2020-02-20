package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementII
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] nums = new int[n];
        for( int i = 0; i < nums.length; i++ )
        {
            nums[i] = s.nextInt();
        }
        
        int[] nextGreaterElements = nextGreaterElements(nums);
        
        for(int num : nextGreaterElements)
            System.out.print( num +" " );
    }

    public static int[] nextGreaterElements( int[] nums )
    {
        int n = nums.length;
        int[] tempNums = new int[2*n];
        
        for(int i=0;i<2*n;i++)
        {
            tempNums[i] = nums[i%n];
        }
        
        Stack<Integer> stack = new Stack();
        int[] res = new int[2*n];
        Arrays.fill( res, -1 );
        for(int i=0;i<2*n;i++)
        {
            while(!stack.isEmpty() && tempNums[stack.peek()]<tempNums[i])
            {
                res[stack.pop()] = tempNums[i];
            }
            
            stack.push( i );
        }
        
        for(int i=0;i<n;i++)
            nums[i] = res[i];

        return nums;
    }
}

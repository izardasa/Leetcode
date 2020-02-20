package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation
{

    public static void main( String[] args )
    {
        int[] A = new int[] {3,2,1};
         nextPermutation( A ) ;
         
         System.out.println(Arrays.toString( A )  );
         
    }

    public static void nextPermutation( int[] nums )
    {
        if( nums == null || nums.length == 0 )
            return;

        int firstDecreasingIndex = -1;
        int i = nums.length - 1;

        while( i > 0 )
        {
            if( nums[i] > nums[i - 1] )
            {
                firstDecreasingIndex = i - 1;
                break;
            }
            i--;
        }

        if(firstDecreasingIndex==-1)
        {
           reverseNumbers(nums, 0, nums.length-1); 
            return;
        }
            
        int decreasingNumber = nums[firstDecreasingIndex];
        int nextGreater = Integer.MAX_VALUE;
        int nextGreaterIndex = 0;
        for( int k = firstDecreasingIndex + 1; k < nums.length; k++ )
        {
            if( nums[k] > decreasingNumber )
            {
                nextGreater = Math.min( nextGreater, nums[k] );
                nextGreaterIndex = k;
            }
        }

        nums[firstDecreasingIndex] = nextGreater;
        nums[nextGreaterIndex] = decreasingNumber;
        reverseNumbers( nums, firstDecreasingIndex+1, nums.length - 1 );
    }
    
    private static void reverseNumbers(int[] nums, int i, int j)
    {
        while(i<j)
        {
            int temp = nums[i];
            nums[i++]= nums[j];
            nums[j--]=temp;
        }
    }

}

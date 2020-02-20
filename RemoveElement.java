package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RemoveElement
{

    public static void main( String[] args )
    {
        int[] nums = new int[] {0,1,2,2,3,0,4,2};
        int n = 2;
        int arraySizePostElementRemoval = removeElement(nums,n);
        System.out.println( arraySizePostElementRemoval );
    }

    private static int removeElement( int[] nums, int value )
    {
        int index=0;
        for( int i = 0; i < nums.length; i++ )
        {
            if(nums[i]!=value)
                nums[index++] = nums[i];
        }
        
        return  index;
    }

}

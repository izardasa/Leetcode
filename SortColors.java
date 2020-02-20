package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortColors
{
    public static void main( String[] args )
    {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{ 2, 0, 1 };
        sortColors.sortColor( nums );
        System.out.println( Arrays.toString( nums ) );
    }

    public void sortColor( int[] nums )
    {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while( mid <= high )
        {
            switch( nums[mid] )
            {
                case 0:
                    swap( nums, low, mid );
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap( nums, mid, high );
                    high--;
            }
        }
    }

    private void swap( int[] nums, int i, int j )
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

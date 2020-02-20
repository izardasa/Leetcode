package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOccurrence
{

    public static void main( String[] args )
    {
        int[] A = new int[] {1,1};
        
         
         System.out.println(Arrays.toString( searchRange(A,1) ) );
         
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstposition =-1;
        int lastPosition =-1;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right)
        {
            int mid = (left+right)/2;
            
            if(target==nums[mid] && nums[mid]>nums[mid-1])
            {
                firstposition = mid;
                break;
            }
            else if(target<=nums[mid])
            {
                right=mid-1;
            }
            else
                left = mid+1;
        }
        
         left = 0;
         right = nums.length-1;
        
        while(left<=right)
        {
            int mid = (left+right)/2;
            
            if(target==nums[mid] && nums[mid]<nums[mid+1])
            {
                lastPosition = mid;
                break;
            }
            else if(target>=nums[mid])
            {
                left = mid+1;
            }
            else
                right = mid-1;
        }
        
        return new int[]{firstposition, lastPosition};
        
        
    }

}

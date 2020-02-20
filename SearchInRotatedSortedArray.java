package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SearchInRotatedSortedArray
{
    public static void main( String[] args )
    {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
       System.out.println( obj.search( new int[] {3,1}, 1 ) );
    }

    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int pivotIndex = findPivotIndex(nums);
        
        int l=0;
        int h=nums.length-1;
        
        if(pivotIndex==0 || pivotIndex==nums.length-1)
                return search(nums, l, h, target);
        else if(target<nums[0])
            return search(nums, pivotIndex+1 , h, target);
        
        else
            return search(nums, 0, pivotIndex, target);
            
    }
    
    private int search(int[] nums, int l, int h, int target)
    {
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]<target)
                l = mid+1;
            else
                h = mid-1;
        }
        
        return -1;
    }
    
    private int findPivotIndex(int[] nums)
    {
        
        int l=0;
        int r=nums.length-1;
        int m=0;
        while(l<=r)
        {
            m = l+(r-l)/2;
            if(nums[m]>nums[l] && nums[m]>nums[r])
            {
                break;
            }
            else if(nums[m]>=nums[l])
                l=m+1;
            else
                r=m-1;
        }
        
        return m;
    }
}

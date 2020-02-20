package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PeakIndexInMountainArray
{

    public static void main( String[] args )
    {

        PeakIndexInMountainArray obj = new PeakIndexInMountainArray();
        System.out.println( obj.peakIndexInMountainArray( new int[] {0,1,0} ) );

    }

    public int peakIndexInMountainArray(int[] nums) {
        int low=0;
        int high= nums.length-1;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            
            if(mid<=0 || mid>=nums.length-1)
                return 0;
            
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            
            if(nums[mid]>nums[mid-1])
                low = mid+1;
            else 
                high = mid-1;
            
                
        }
        return 0;
    }
}

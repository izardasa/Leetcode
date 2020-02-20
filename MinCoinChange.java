package Leetcode;

import java.util.Arrays;

public class MinCoinChange
{
    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3)
            return 0;
        
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++)
        {
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                
                if(sum>target)
                    right--;
                else
                    left++;
               
                if(Math.abs( sum-target )<Math.abs( target - closestSum ))
                {
                   closestSum = sum;
                }
                
            }
        }
        return closestSum;
    }

    public static void main( String[] args )
    {

        System.out.println( threeSumClosest( new int[] {-3,-2,-5,3,-4}, -1 ) ); 
        
    }

}

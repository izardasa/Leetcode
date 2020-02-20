package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JumpGameII
{

    public static void main( String[] args )
    {
        JumpGameII obj =new JumpGameII();
        System.out.println( obj.jump( new int[] {2,3,1,1,4} ) );

    }

    public int jump(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] jumps= new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j+nums[j]>=i)
                {
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
                }
            }
        }
        
        return jumps[nums.length-1];
        
    }
}

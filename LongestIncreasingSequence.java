package Leetcode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LongestIncreasingSequence
{

    public static void main( String[] args )
    {

        LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
        int lengthOfLIS = longestIncreasingSequence.lengthOfLIS( new int[] {1,12,11,4 , 30, 5, 7} );
        System.out.println( lengthOfLIS );
    }

    public int lengthOfLIS( int[] nums )
    {
        if( nums == null || nums.length == 0 )
            return 0;

        int[] dp = new int[ nums.length ];
        int len = 0;

        for( int num : nums )
        {
            int index = Arrays.binarySearch( dp, 0, len, num );
            if(index<0)
                index = -(index+1);
            
            dp[index] = num;
            if(index==len)
                len++;
        }
        
        return len;

    }
}
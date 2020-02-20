package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContinuousOnesIII
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int k  = s.nextInt();
        int[] nums = new int[n];
        
        for( int i = 0; i < n; i++ )
        {
            nums[i] = s.nextInt();
        }
        
        int count = getContigousOnesLengthWithKFlips(nums, k);
        System.out.println( count );
     }

    private static int getContigousOnesLengthWithKFlips( int[] A, int K )
    {
        int i=0,j=0;
        while(i<A.length)
        {
            if(A[i]==0) 
                K--;
            
            if(K<0)
            {
                if(A[j]==0)
                {
                    K++;
                }
                j++;
            }
            i++;
        }
        
        return i-j;
    }

}
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayPartitionI
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] nums = new int[ n ];

        for( int i = 0; i < n; i++ )
        {
            nums[i] = s.nextInt();
        }

        int sum = 0;
        for( int i = 0; i < nums.length - 1; i += 2 )
        {
            sum += nums[i];
        }
        
        System.out.println( sum );
    }

}

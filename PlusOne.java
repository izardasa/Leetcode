package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlusOne
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int[] digits = new int[ n ];
        for( int i = 0; i < n; i++ )
        {
            digits[i] = s.nextInt();
        }

        int[] res = plusOne( digits );
        for( int num: res )
        {
            System.out.print( num );
        }
    }

    public static int[] plusOne( int[] digits )
    {
        int n = digits.length;
        for(int i= n-1;i>=0;i--)
        {
            if(digits[i]!=9)
            {
                digits[i]++;
                return digits;
            }
            
            if(digits[i]==9)
                digits[i]=0;
        }
        
        int[] res = new int[n+1];
        res[0]=1;
        return res;
    }
}
package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReverseInteger
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int res = reverse(n);
        System.out.println( res );
      
    }

    public static int reverse(int x) {
        boolean negative = x<0;
        
        long num=0;
        x=Math.abs(x);
        while(x>0)
        {
            int rem = x%10;
            num = num*10+rem;
            x/=10;
        }
        
        if(num>Integer.MAX_VALUE)
            num=0;
        return negative?-(int)num:(int)num;
    }
    
}

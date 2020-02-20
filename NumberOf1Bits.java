package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOf1Bits
{
   
    public int hammingWeight(int n) {
        int count=0;
        long m = (long)n;
        while(m>0)
        {
            if((m&1)==1)
                count++;
            
            m>>=1;
        }
        
        return count;
    }
    
    public static void main( String[] args )
    {
        NumberOf1Bits obj = new NumberOf1Bits();

       System.out.println( obj.hammingWeight( 111111101 ) ); 
    }

}

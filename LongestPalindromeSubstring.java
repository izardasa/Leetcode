package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LongestPalindromeSubstring
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        String str =s.next();
        
        System.out.println( longestPalindrome( str ) );


    }

    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        if(s==null || s.length()==0)
            return longestPalindrome;
        
        int len=0;
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            
            len = Math.max(len1, len2);
            if(len>end-start)
            {
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        
        return s.substring(start,end);
    }
    
    private static int expandFromMiddle(String s, int i, int j)
    {
        while(i>= 0 && j <s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        
        return j-i+1;
    }
}

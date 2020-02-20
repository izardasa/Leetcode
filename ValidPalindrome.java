package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ValidPalindrome
{

    public static void main( String[] args )
    {
        String str = "race a car";
        boolean palindrome = isPalindrome( str );
        System.out.println( palindrome );
    }

    public static boolean isPalindrome( String s )
    {
        StringBuilder sb = new StringBuilder();

        int l = s.length();

        for( int i = 0; i < l; i++ )
        {
            char c = s.charAt( i );
            if( Character.isDigit( c ) || Character.isLetter( c ) )
            {
                sb.append( c );
            }
            
            
        }
        
        String fixed_string = sb.toString();
        fixed_string = fixed_string.toLowerCase();
        
        int left = 0;
        int right = fixed_string.length()-1;
        
        while(left<right)
        {
            if(fixed_string.charAt( left++ )!=fixed_string.charAt( right-- ))
                return false;
        }
        return true;
        
    }

}

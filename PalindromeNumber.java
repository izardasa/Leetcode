package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PalindromeNumber
{

    public static void main( String[] args )
    {
        int number = 1;
        boolean palindrome = isPalindrome(number);
        System.out.println( palindrome );
    }

    private static boolean isPalindrome( int number )
    {
       if(number<0)
           return false;
       
       int reversedNumber = reverseNumber( number );
       if(number==reversedNumber)
           return true;
       
       return false;
        
    }

    private static int reverseNumber( int number )
    {
        int rev = 0;
        while( number > 0 )
        {
            int rem = number % 10;
            rev = rev * 10 + rem;
            number /= 10;
        }
        return rev;
    }
}

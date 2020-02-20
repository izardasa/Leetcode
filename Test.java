package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Test
{

    public static void main( String[] args )
    {

        int n = 0;
        System.out.println( isPowerOfTwo( n ) );

    }

    public static boolean isPowerOfTwo( int n )
    {

        int count = 0;
        while( n > 0 )
        {
            if( ( n & 1 ) == 1 )
                count++;
            n >>= 1;

            if( count > 1 )
                return false;

        }

        if( count == 1  )
            return true;
        return false;
    }

}

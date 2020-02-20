package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RomanToInteger
{
    public static void main( String[] args )
    {
        RomanToInteger obj = new RomanToInteger();
        System.out.println( obj.romanToInt( "MCMXCIV" ) );
    }

    public int romanToInt( String s )
    {
        if( s == null && s.length() == 0 )
            return 0;

        HashMap<Character, Integer> map = new HashMap();
        map.put( 'I', 1 );
        map.put( 'V', 5 );
        map.put( 'X', 10 );
        map.put( 'L', 50 );
        map.put( 'C', 100 );
        map.put( 'D', 500 );
        map.put( 'M', 1000 );

        int l = s.length();
        int sum = 0;
        for( int i = 0; i < l; i++ )
        {

            if( i + 1 < l )
            {
                int pairValue = specialCase( s.charAt( i ), s.charAt( i + 1 ) );
                if( pairValue > 0 )
                {
                    sum += pairValue;
                    i++;
                    continue;
                }
            }
            sum += map.get( s.charAt( i ) );
        }
        return sum;

    }

    private int specialCase( char c1, char c2 )
    {
        if( c1 == 'I' && c2 == 'V' )
            return 4;
        if( c1 == 'I' && c2 == 'X' )
            return 9;
        if( c1 == 'X' && c2 == 'L' )
            return 40;
        if( c1 == 'X' && c2 == 'C' )
            return 90;
        if( c1 == 'C' && c2 == 'D' )
            return 400;
        if( c1 == 'C' && c2 == 'M' )
            return 900;

        return 0;
    }
}

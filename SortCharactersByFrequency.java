package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortCharactersByFrequency
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        String str = frequencySort( s.next() );
        System.out.println( str );
    }

    private static String frequencySort( String s )
    {
        HashMap<Character, Integer> charFrequencyMap = new HashMap();

        for( char c : s.toCharArray() )
        {
            charFrequencyMap.put( c, charFrequencyMap.getOrDefault( c, 0 ) + 1 );
        }

        PriorityQueue<Character> maxHeap =
            new PriorityQueue<Character>( ( a, b ) -> charFrequencyMap.get( b ) - charFrequencyMap.get( a ) );

        maxHeap.addAll( charFrequencyMap.keySet() );
        
        StringBuilder sb = new StringBuilder();
        while( !maxHeap.isEmpty() )
        {
            char c = maxHeap.remove();
            int freq = charFrequencyMap.get( c );

            while( freq-- > 0 )
            {
                sb.append( c );
            }

        }
        return sb.toString();

    }
}

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HighFive
{
    public static void main( String[] args )
    {
        HighFive obj = new HighFive();
        System.out.println( Arrays.toString( obj.highFive( new int[][]{ { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 },
            { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 }, { 1, 100 }, { 2, 100 }, { 2, 76 } } ) ) );
    }

    public int[][] highFive( int[][] items )
    {
        HashMap<Integer, Integer> totalMap = new HashMap();
        HashMap<Integer, Integer> countMap = new HashMap();
        if( items == null || items.length == 0 )
            return new int[][]{ {} };
        Arrays.sort( items, ( a, b ) -> b[1] - a[1] );
        for( int i = 0; i < items.length; i++ )
        {
            if( countMap.getOrDefault( items[i][0], 0 ) < 5 )
            {
                int studentId = items[i][0];
                countMap.put( studentId, countMap.getOrDefault( studentId, 0 ) + 1 );
                totalMap.put( studentId, totalMap.getOrDefault( studentId, 0 ) + items[i][1] );
            }
        }

        int n = totalMap.size();
        int[][] result = new int[ n ][ 2 ];

        for( int i = 1; i <= 1000; i++ )
        {
            if( totalMap.containsKey( i ) )
            {
                result[i-1][0] = i;
                result[i-1][1] = totalMap.get( i ) / countMap.get( i );
            }
        }

        return result;

    }
}

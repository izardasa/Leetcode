package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class UniqueNumberOfOccurrences
{
    public static void main( String[] args )
    {
        UniqueNumberOfOccurrences obj = new UniqueNumberOfOccurrences();
        System.out.println( obj.uniqueOccurrences(new int[]{1,2} )) ;
    }

    public boolean uniqueOccurrences( int[] arr )
    {
        HashMap<Integer, Integer> occuranceMap = new HashMap();

        for( Integer num : arr )
        {
            occuranceMap.put( num, occuranceMap.getOrDefault( num, 0 ) + 1 );
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue( ( a, b ) -> occuranceMap.get( a ) - occuranceMap.get( b ) );

        for( int key : occuranceMap.keySet() )
        {
            minHeap.add( key );
        }

        int previous = minHeap.remove();

        while( !minHeap.isEmpty() )
        {
            int current = minHeap.remove();
            System.out.print( previous + " " + current );
            if( current == previous )
                return false;

            previous = current;
        }
        return true;

    }
}

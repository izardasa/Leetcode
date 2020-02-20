package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingRoomsIIArray
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();

        int[][] intervals = new int[ n ][ 2 ];
        for( int i = 0; i < n; i++ )
        {
            intervals[i][0] = s.nextInt();
            intervals[i][1] = s.nextInt();
        }

        int minNumberOfRooms = getMinimumNumberOfMeetingRooms( intervals );
        System.out.println( minNumberOfRooms );
    }

    private static int getMinimumNumberOfMeetingRooms( int[][] intervals )
    {
        if( intervals == null || intervals.length == 0 )
            return 0;

        Arrays.sort( intervals, ( a, b ) -> a[0] - b[0] );

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>( ( a, b ) -> a[1] - b[1] );
        minHeap.add( intervals[0] );

        for(int i=1;i<intervals.length;i++)
        {
            int[] currentTime = intervals[i];
            int[] earliestTime = minHeap.remove();
            
            if(currentTime[0]>=earliestTime[1])
                earliestTime[1] = currentTime[1];
            else
                minHeap.add( currentTime );
            
            minHeap.add( earliestTime );
        }
        return minHeap.size();
    }

}

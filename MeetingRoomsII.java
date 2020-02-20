package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Interval
{
    int start;
    int end;

    public Interval()
    {
    }

    public Interval( int start, int end )
    {
        super();
        this.start = start;
        this.end = end;
    }

}

public class MeetingRoomsII
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        Interval[] intervals = new Interval[n];
        for(int i=0;i<n;i++)
        {
            intervals[i] = new Interval(s.nextInt(),s.nextInt());
        }
       
        int minNumberOfRooms = getMinimumNumberOfMeetingRooms(intervals);
        System.out.println( minNumberOfRooms );
    }

    private static int getMinimumNumberOfMeetingRooms( Interval[] intervals )
    {
        if(intervals==null || intervals.length==0)
            return 0;
        
        Arrays.sort( intervals, (o1,o2)->o1.start-o2.start );
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((o1,o2)->o1.end-o2.end);
        minHeap.add( intervals[0] );
        
        for(int i=1;i<intervals.length;i++)
        {
            Interval earliestMeeting = minHeap.remove();
            Interval currentMeeting = intervals[i];
            
            if(earliestMeeting.end<=currentMeeting.start)
            {
                earliestMeeting.end = currentMeeting.end;
            }
            else
            {
                minHeap.add( currentMeeting );
            }
            
            minHeap.add( earliestMeeting );
        }
        
        return minHeap.size();
    }

    
}

package Leetcode;

import java.util.PriorityQueue;

class MedianFinder
{

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( ( a, b ) -> b - a );

    /** initialize your data structure here. */
    public MedianFinder()
    {

    }

    public void addNum( int num )
    {
        if( maxHeap.isEmpty() )

            maxHeap.add( num );
        else if( num < maxHeap.peek() )
        {
            maxHeap.add( num );
            if( maxHeap.size() - minHeap.size() == 2 )
            {
                minHeap.add( maxHeap.remove() );
            }
        }
        else
        {
            minHeap.add( num );
            if( minHeap.size() - maxHeap.size() == 2 )
            {
                maxHeap.add( minHeap.remove() );
            }
        }
    }

    public double findMedian()
    {

        if( minHeap.size() > maxHeap.size() )
            return minHeap.peek();
        if( maxHeap.size() > minHeap.size() )
            return maxHeap.peek();
        return ( minHeap.peek() + maxHeap.peek() ) / 2.0;

    }

    public static void main( String[] args )
    {
        MedianFinder obj = new MedianFinder();
        obj.addNum( 1 );
        obj.addNum( 2 );
        double param_2 = obj.findMedian();
        System.out.println( param_2 );

    }
}

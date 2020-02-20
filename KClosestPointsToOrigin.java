package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestPointsToOrigin
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int K = s.nextInt();
        int[][] points = new int[ n ][ 2 ];

        for( int i = 0; i < n; i++ )
        {
            points[i][0] = s.nextInt();
            points[i][1] = s.nextInt();
        }

        int[][] kClosest = kClosest( points, K );
        
        for(int[] point : kClosest)
            System.out.println( point[0]+ " "+ point[1] );
    }

    public static int[][] kClosest( int[][] points, int K )
    {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        
        for(int i=0;i<points.length;i++)
        {
            maxHeap.add( points[i] );
            
            if(maxHeap.size()>K)
                maxHeap.remove();
        }
        
        int[][] res = new int[K][2];
        for(int i=0;i<K;i++)
        {
            res[i] = maxHeap.remove();
        }
        return res; 
    }
}

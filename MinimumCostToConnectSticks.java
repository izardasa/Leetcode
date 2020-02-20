package Leetcode;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostToConnectSticks
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] cost = new int[ n ];

        for( int i = 0; i < n; i++ )
            cost[i] = s.nextInt();

        int minCost = getMinCostToConnectSticks( cost );
        System.out.println( minCost );
    }

    private static int getMinCostToConnectSticks( int[] costs )
    {
        int totalCost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for( Integer cost : costs )
            minHeap.add( cost );
        
        while(minHeap.size()>1)
        {
            int sum = minHeap.remove()+minHeap.remove();
            totalCost+=sum;
            
            minHeap.add( sum );
        }
        return totalCost;

    }
}

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LastStoneWeight
{

    public static void main( String[] args )
    {
        int[] weights = new int[] {2,7,4,1,8,1};
        int lastStoneWeight = lastStoneWeight(weights);
        System.out.println( lastStoneWeight );
    }

    public static int lastStoneWeight( int[] stones )
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        for(int i=0;i<stones.length;i++)
        {
            maxHeap.add( -stones[i] );
        }
        
        while(maxHeap.size()>1)
        {
            int heaviest = -maxHeap.remove();
            int secondHeaviest = -maxHeap.remove();
            
            if(heaviest!=secondHeaviest)
                maxHeap.add(-( heaviest-secondHeaviest ));
        }
        
        return maxHeap.size()==0?0:-maxHeap.remove();
    }
}

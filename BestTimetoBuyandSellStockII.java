package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BestTimetoBuyandSellStockII
{

    public static void main( String[] args )
    {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println( maxProfit( prices ) );

    }

    public static int maxProfit( int[] prices )
    {
        int profit =0;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i+1]>prices[i])
                profit+=prices[i+1]-prices[i];
        }
        return profit;
    }
}

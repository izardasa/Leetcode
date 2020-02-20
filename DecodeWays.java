package Leetcode;

import java.util.Arrays;

public class DecodeWays
{
    public static int coinChange( int[] coins, int amount )
    {
        if( coins == null || coins.length == 0 )
            return 0;
        // int result = coinChangeHelper( coins, amount, 0 );
        int[] dp = new int[ amount + 1 ];
        int result = coinChangeHelperBottomUp( coins, amount,  dp );
        return result == Integer.MAX_VALUE ? -1 : result;

    }

    private static int coinChangeHelperBottomUp( int[] coins, int amount, int[] dp )
    {
        if( amount == 0 )
            return 0;

       Arrays.fill( dp, amount+1 );
        
       dp[0]=0;
 
        for( int t = 1; t <= amount; t++ )
        {
            for( int c = 0; c <coins.length; c++ )
            {
               if(t>=coins[c])
                   dp[t] = Math.min( dp[t], dp[t-coins[c]]+1 );
                
            }
        }
        return dp[amount]>amount?-1:dp[amount];

    }

    private static int coinChangeHelperTopDown( int[] coins, int amount, int currentIndex, Integer[][] dp )
    {
        if( amount == 0 )
            return 0;

        if( currentIndex >= coins.length || amount < 0 )
            return Integer.MAX_VALUE;

        int include = Integer.MAX_VALUE;
        if( dp[currentIndex][amount] == null )
        {
            if( coins[currentIndex] <= amount )
            {
                include = coinChangeHelperTopDown( coins, amount - coins[currentIndex], currentIndex, dp );
                if( include != Integer.MAX_VALUE )
                    include++;
            }

            int exclude = coinChangeHelperTopDown( coins, amount, currentIndex + 1, dp );

            dp[currentIndex][amount] = Math.min( include, exclude );
        }
        return dp[currentIndex][amount];

    }

    private static int coinChangeHelper( int[] coins, int amount, int currentIndex )
    {
        if( amount == 0 )
            return 0;

        if( currentIndex >= coins.length || amount < 0 )
            return Integer.MAX_VALUE;

        int include = Integer.MAX_VALUE;
        if( coins[currentIndex] <= amount )
        {
            include = coinChangeHelper( coins, amount - coins[currentIndex], currentIndex );
            if( include != Integer.MAX_VALUE )
                include++;
        }

        int exclude = coinChangeHelper( coins, amount, currentIndex + 1 );

        return Math.min( include, exclude );

    }

    public static void main( String[] args )
    {

        System.out.println( coinChange( new int[]{ 2}, 3 ) );
    }

}

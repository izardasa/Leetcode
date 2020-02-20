package Leetcode;

import java.util.Stack;

public class MaximalSquare
{
    public static void main( String[] args )
    {
        char[][] A = new char[][]{{'0','1'}};
        MaximalSquare medianOfTwoSortedArray = new MaximalSquare();
        System.out.println( medianOfTwoSortedArray.maximalSquare( A));
    }

    public int maximalSquare( char[][] matrix )
    {
        if( matrix == null || matrix.length == 0 )
            return 0;
        int maxSquare = 0;
        int[][] dp = new int[ matrix.length ][ matrix[0].length ];
        for( int i = 0; i < matrix.length; i++ )
        {
            for( int j = 0; j < matrix[0].length; j++ )
            {
                if( i == 0 || j == 0 )
                {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else
                {
                    if( matrix[i][j] == '1' )
                    {
                        dp[i][j] = Math.min( Math.min( dp[i - 1][j], dp[i][j - 1] ), dp[i - 1][j - 1] ) + 1;
                    }
                }
                System.out.print( dp[i][j] );
                if( dp[i][j] > maxSquare )
                    maxSquare = dp[i][j];
            }
        }

        return maxSquare * maxSquare;

    }
}

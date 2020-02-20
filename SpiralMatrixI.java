package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrixI
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int r = s.nextInt();
        int c = s.nextInt();
        int[][] A = new int[ r ][ c ];
        for( int i = 0; i < r; i++ )
        {
            for( int j = 0; j < c; j++ )
            {
                A[i][j] = s.nextInt();
            }
        }

        List<Integer> spiralOrder = getIntegersOfMatrixInSpiralOrder( A );

        for( Integer num : spiralOrder )
            System.out.print( num + " " );
    }

    private static List<Integer> getIntegersOfMatrixInSpiralOrder( int[][] matrix )
    {
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> res = new ArrayList<Integer>();
        while( rowBegin <= rowEnd && colBegin <= colEnd )
        {
            for( int i = colBegin; i <= colEnd; i++ )
            {
                res.add( matrix[rowBegin][i] );
            }
            rowBegin++;

            for( int i = rowBegin; i <= rowEnd; i++ )
            {
                res.add( matrix[i][colEnd] );
            }
            colEnd--;

            if( rowBegin <= rowEnd )
            {
                for( int i = colEnd; i >= colBegin; i-- )
                {
                    res.add( matrix[rowEnd][i] );
                }
            }
            rowEnd--;

            if( colBegin <= colEnd )
            {
                for( int i = rowEnd; i >= rowBegin; i-- )
                {
                    res.add( matrix[i][colBegin] );
                }
            }
            colBegin++;
        }
        return res;
    }

}

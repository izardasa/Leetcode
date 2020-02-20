package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraversalOfMatrix
{
    public static List<List<Integer>> diagonalTraversal( int[][] A )
    {
        List<List<Integer>> result = new ArrayList<>();

        int N = A.length;
        int M = A[0].length;
        int count = 0;
        for( int i = 0; i < M; i++ )
        {
            count++;
            int row = 0;
            int col = i;
            List<Integer> currentResult = new ArrayList<>();
            while( row < N && col >= 0 )
            {
                currentResult.add( A[row][col] );
                row++;
                col--;
            }

            if( count % 2 != 0 )
                Collections.reverse( currentResult );

            result.add( currentResult );
        }
        
        for(int i=1;i<M;i++)
        {
            count++;
            int row=i;
            int col = N-1;
            List<Integer> currentResult = new ArrayList<>();
            while(row<M && col>0)
            {
                currentResult.add( A[row][col] );
                row++;
                col--;
            }
            
            if(count%2!=0)
                Collections.reverse( currentResult );
            
            result.add( currentResult );
        }

        return result;
    }

    public static void main( String[] args )
    {
        int[][] A = new int[][]{ { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        System.out.println( diagonalTraversal( A ) ); 
    }
}

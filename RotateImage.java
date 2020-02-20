package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RotateImage
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[][] matrix = new int[ n ][ n ];

        for( int i = 0; i < matrix.length; i++ )
        {
            for( int j = 0; j < matrix[0].length; j++ )
            {
                matrix[i][j] = s.nextInt();
            }
        }

        rotate( matrix );

        for( int i = 0; i < matrix.length; i++ )
        {
            for( int j = 0; j < matrix[0].length; j++ )
            {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }

    }

    public static void rotate( int[][] matrix )
    {
        if( matrix == null || matrix.length == 0 )
            return;
        for( int i = 0; i < matrix.length; i++ )
        {
            for( int j = 0; j < matrix[0].length; j++ )
            {
                if( i > j )
                {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for( int i = 0; i < matrix.length; i++ )
        {
            for( int j = 0; j < matrix[0].length; j++ )
            {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }

        for( int i = 0; i < matrix.length; i++ )
        {
            int left = 0;
            int right = matrix[0].length - 1;
            while( left < right )
            {

                int temp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = temp;
            }
        }
    }

}

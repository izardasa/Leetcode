package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class SquareOfASortedArray
{
    public static void main( String[] args )
    {
        SquareOfASortedArray squareOfASortedArray = new SquareOfASortedArray();
        System.out.println( Arrays.toString( squareOfASortedArray.sortedSquares( new int[]{ -1 } ) ) );
    }

    public int[] sortedSquares( int[] A )
    {
        int n = A.length;
        int[] res = new int[ n ];

        int negativePointer = 0;
        int positivePointer = n - 1;

        while(negativePointer < n && A[negativePointer] < 0  )
            negativePointer++;

        positivePointer = negativePointer;
        negativePointer -= 1;
        int index = 0;
        while( negativePointer >= 0 && positivePointer < n )
        {
            int negativeSquare = A[negativePointer] * A[negativePointer];
            int positiveSquare = A[positivePointer] * A[positivePointer];

            if( negativeSquare < positiveSquare )
            {
                res[index] = negativeSquare;
                negativePointer--;
            }
            else
            {
                res[index] = positiveSquare;
                positivePointer++;
            }
            index++;
        }

        while( negativePointer >= 0 )
        {
            res[index++] = A[negativePointer] * A[negativePointer];
            negativePointer--;
        }

        while( positivePointer < n )
        {
            res[index++] = A[positivePointer] * A[positivePointer];
            positivePointer++;
        }

        return res;
    }
}

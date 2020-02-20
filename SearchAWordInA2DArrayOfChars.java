package Leetcode;

import java.util.Scanner;

public class SearchAWordInA2DArrayOfChars
{

    public static void main( String[] args )
    {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        Scanner s = new Scanner( System.in );
        String word = s.next();

        for( int i = 0; i < board.length; i++ )
        {
            for( int j = 0; j < board[0].length; j++ )
            {
                if( isWordFound( board, word, i, j, 0 ) )
                {
                    System.out.println( "Found" );
                    return;
                }
            }

        }
        System.out.println( false );
    }

    private static boolean isWordFound( char[][] board, String word, int i, int j, int index )
    {
        if( word.length() == index )
            return true;

        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt( index ) != board[i][j] )
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean wordFound =
            isWordFound( board, word, i + 1, j, index + 1 ) || isWordFound( board, word, i, j + 1, index + 1 )
                || isWordFound( board, word, i, j - 1, index + 1 ) || isWordFound( board, word, i - 1, j, index + 1 );

        board[i][j] = temp;

        return wordFound;
    }
}

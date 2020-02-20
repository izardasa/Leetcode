package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameOfLife
{

    public void gameOfLife( int[][] board )
    {
        if( board == null || board.length == 0 )
            return;

        int m = board.length;
        int n = board[0].length;
        Queue<Integer> lives = new LinkedList();
        for( int i = 0; i < m; i++ )
        {
            for( int j = 0; j < n; j++ )
            {
                adjacentLives( board, lives, i, j );
            }
        }

        for( int i = 0; i < m; i++ )
        {
            for( int j = 0; j < n; j++ )
            {
                int adjLives = lives.poll();
                if( board[i][j] == 1 )
                {
                    if( adjLives < 2 || adjLives > 3 )
                        board[i][j] = 0;
                }
                else
                {
                    if( adjLives == 3 )
                        board[i][j] = 1;
                }
            }
        }
    }

    private void adjacentLives( int[][] board, Queue<Integer> lives, int row, int col )
    {
        int r[] = { 0, 0, -1, -1, -1, 1, 1, 1 };
        int c[] = { -1, 1, -1, 0, 1, -1, 0, 1 };
        int cellLive = 0;
        for( int i = 0; i < r.length; i++ )
        {
            int newRow = row + r[i];
            int newCol = col + c[i];

            if( newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length )
                continue;

            if( board[newRow][newCol] == 1 )
                cellLive++;
        }

        lives.add( cellLive );
    }

    public static void main( String[] args )
    {
        GameOfLife obj = new GameOfLife();

        int[][] cells = new int[][]{ { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

        obj.gameOfLife( cells );
        
        for(int i=0;i<cells.length;i++)
        {
            for(int j=0;j<cells[0].length;j++)
            {
                System.out.print( cells[i][j] +" ");
            }
            System.out.println(  );
        }
    }

}

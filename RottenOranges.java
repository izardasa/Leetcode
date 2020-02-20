package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges
{
    public static void main( String[] args )
    {
        int[][] A = {{2,2},{1,1},{0,0},{2,2}};
        RottenOranges obj = new RottenOranges();
        System.out.println( obj.orangesRotting( A ) );
    }

    public int orangesRotting( int[][] grid )
    {
        int dr[] = { 1, 0, -1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        Queue<Integer> queue = new LinkedList();
        HashMap<Integer, Integer> map = new HashMap();
        int R = grid.length;
        int C = grid[0].length;
        for( int r = 0; r < R; r++ )
        {
            for( int c = 0; c < C; c++ )
            {
                if( grid[r][c] == 2 )
                {
                    int index = r * C + c;
                    queue.add( index );
                    map.put( index, 0 );
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while( !queue.isEmpty() )
        {
            int index = queue.poll();
            int r = index / C;
            int c = index % C;
            grid[r][c] = 2;
            for( int i = 0; i < 4; i++ )
            {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if( newR >= 0 && newR < R && newC >= 0 && newC < C && grid[newR][newC] == 1 )
                {
                    queue.add( newR * C + newC );
                    map.put( newR * C + newC, map.get( index ) + 1 );
                    grid[newR][newC] = 2;
                }
            }
            ans = map.get( index );
        }

        for( int r = 0; r < R; r++ )
            for( int c = 0; c < C; c++ )
                if( grid[r][c] == 1 )
                    return -1;
        return ans;
    }
}

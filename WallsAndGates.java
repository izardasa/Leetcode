package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WallsAndGates
{

    public static void main( String[] args )
    {
        int INF = Integer.MAX_VALUE;

        int[][] A = new int[][]{ 
            { INF, -1, 0, INF }, 
            { INF, INF, INF, -1 }, 
            { INF, -1, INF, -1 }, 
            { 0, -1, INF, INF } };

        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                if(A[i][j]==0)
                    dfs(A,i,j,0);
            }
        }
        
        for( int i = 0; i < A.length; i++ )
        {
            for( int j = 0; j < A[0].length; j++ )
            {
                System.out.print(A[i][j]+ " "  );
            }
            System.out.println(  );
        }
    }

    private static void dfs(int[][] A, int i, int j, int count )
    {
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || count>A[i][j])
            return;
        
        A[i][j] = count;
        dfs(A, i+1,j, count+1);
        dfs(A, i,j+1, count+1);
        dfs(A, i,j-1, count+1);
        dfs(A, i-1,j, count+1);
    }

}

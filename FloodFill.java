package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FloodFill
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int[][] image = {{0,0,0},{0,1,1}};
        
        floodFill( image, 1, 1, 1 );
       


    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0)
            return null;
        
        dsf(image, sr,sc, newColor, image[sr][sc]);
        
        return image;
        
    }
    
    private static void dsf(int[][] image, int i, int j, int newColor, int oldColor)
    {
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=oldColor )
            return;
        
        image[i][j] = newColor;
        dsf(image, i+1, j, newColor, oldColor);
        dsf(image, i-1, j, newColor, oldColor);
        dsf(image, i, j+1, newColor, oldColor);
        dsf(image, i, j-1, newColor, oldColor);

        
    }
}

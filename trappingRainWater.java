package Leetcode;

import java.util.Scanner;

public class trappingRainWater
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] height = new int[ n ];
        for( int i = 0; i < n; i++ )
            height[i] = s.nextInt();

        System.out.println( trap( height ) );
    }

    public static int trap( int[] height )
    {
        int n = height.length;
        int[] leftMax = new int[ n ];
        int[] rightMax = new int[ n ];

        int max = -1;
        for( int i = 0; i < n; i++ )
        {
            max = Math.max( height[i], max );
            leftMax[i] = max;
        }

        max = -1;
        for( int i = n - 1; i >= 0; i-- )
        {
            max = Math.max( height[i], max );
            rightMax[i] = max;
        }

        int res = 0;
        for( int i = 0; i < n; i++ )
        {
            res += Math.min( leftMax[i], rightMax[i] ) - height[i];
        }
        return res;
    }

}

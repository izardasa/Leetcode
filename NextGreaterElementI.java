package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementI
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n1 = s.nextInt();
        int n2 = s.nextInt();

        int[] nums1 = new int[ n1 ];
        for( int i = 0; i < n1; i++ )
        {
            nums1[i] = s.nextInt();
        }
        int[] nums2 = new int[ n2 ];
        for( int i = 0; i < n2; i++ )
        {
            nums2[i] = s.nextInt();
        }

        for( int num : nextGreaterElement( nums1, nums2 ) )
            System.out.print( num + " " );

    }

    public static int[] nextGreaterElement( int[] nums1, int[] nums2 )
    {
        int n2 = nums2.length;
        int[] res = new int[ n2 ];
        HashMap<Integer, Integer> map = new HashMap();

        Stack<Integer> stack = new Stack();
        for( int i = 0; i < n2; i++ )
        {
            while( !stack.isEmpty() && nums2[stack.peek()] < nums2[i] )
            {
                if( !map.containsKey( nums2[stack.peek()] ) )
                {
                    map.put( nums2[stack.pop()], nums2[i] );
                }

            }

            stack.push( i );
        }

        int[] result = new int[nums1.length];
        Arrays.fill( result, -1 );
        for( int i = 0; i < nums1.length; i++ )
        {
            if( map.containsKey( nums1[i] ) )
                result[i] = map.get( nums1[i] );
        }

        return result;
    }
}

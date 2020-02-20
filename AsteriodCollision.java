package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class AsteriodCollision
{
    public static void main( String[] args )
    {
        char[][] A = new char[][]{ { '0', '1' } };
        AsteriodCollision asteroidCollision = new AsteriodCollision();
        System.out.println( Arrays.toString( asteroidCollision.asteroidCollision( new int[]{ -2, -1, 1, 2 } ) ) );
    }

    public int[] asteroidCollision( int[] asteroids )
    {
        if( asteroids == null || asteroids.length == 0 )
            return new int[]{};
        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < asteroids.length; i++ )
        {
            if( stack.isEmpty() || asteroids[i] > 0 )
                stack.push( asteroids[i] );
            else
            {
                while( true )
                {
                    int peek = stack.peek();
                    if( peek < 0 )
                    {
                        stack.push( asteroids[i] );
                        break;
                    }
                    else if( peek > -asteroids[i] )
                        break;
                    else if( peek == -asteroids[i] )
                    {
                        stack.pop();
                        break;
                    }
                    else if( peek < -asteroids[i] )
                    {
                        stack.pop();

                        if( stack.isEmpty() )
                        {
                            stack.push( asteroids[i] );
                            break;
                        }

                    }
                }

            }

        }

        int[] result = new int[ stack.size() ];
        for( int i = stack.size() - 1; i >= 0; i-- )
            result[i] = stack.pop();

        return result;
    }
}

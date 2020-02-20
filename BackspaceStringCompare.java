package Leetcode;

import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompare
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
     

        boolean backspaceCompare = backspaceCompare( s.next(), s.next() );
        System.out.println( backspaceCompare );
    }

    public static boolean backspaceCompare( String S, String T )
    {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for( int i = 0; i < S.length(); i++ )
        {
            char c = S.charAt( i );
            if( S.charAt( i ) != '#')
                sStack.push( c );
            else if(sStack.size()==0)
                continue;
            else
                sStack.pop();
        }

        for( int i = 0; i < T.length(); i++ )
        {
            char c = T.charAt( i );
            if( T.charAt( i ) != '#' )
                tStack.push( c );
            else if(tStack.size()==0)
                continue;
            else
                tStack.pop();
        }

        if( sStack.size() == tStack.size() )
        {
            while( sStack.size() > 0 )
            {
                if( sStack.pop() != tStack.pop() )
                    return false;

            }
        }
        else
            return false;
        
        return true;
    }

}
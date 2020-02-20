package Leetcode;

import java.util.Stack;

public class DecodeString
{
    public static void main( String[] args )
    {
        DecodeString decodeString = new DecodeString();
        System.out.println( decodeString.decodeString( "2[ab4[c]]3[a]" ) );
    }

    public String decodeString( String s )
    {
        int num = 0;
        Stack<Integer> countStack = new Stack();
        Stack<String> wordStack = new Stack();
        String currentString = "";
        String res = "";
        int index = 0;
        while( index < s.length() )
        {
            if( Character.isDigit( s.charAt( index ) ) )
            {
                while( Character.isDigit( s.charAt( index ) ) )
                {
                    num = num * 10 + ( s.charAt( index ) - '0' );
                    index++;
                }

                countStack.push( num );
            }
            else if( s.charAt( index ) == '[' )
            {
                wordStack.push( res );
                res = "";
                num=0;
                index++;
            }
            else if( s.charAt( index ) == ']' )
            {
                int count = countStack.pop();
                StringBuilder sb = new StringBuilder( wordStack.pop() );
                while( count-- > 0 )
                {
                    sb.append( res );
                }
                res = sb.toString();
                index++;

            }
            else
            {

                res += s.charAt( index );
                index++;
            }
        }

        return res;
    }
}

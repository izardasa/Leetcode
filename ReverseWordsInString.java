package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReverseWordsInString
{

    public static void main( String[] args )
    {

        ReverseWordsInString obj = new ReverseWordsInString();
        System.out.println( obj.reverseWords( " " ) );

    }

    public String reverseWords( String s )
    {
        if( s == null || s.length() == 0 )
            return "";

        s = s.trim();

        String[] words = s.split( " " );
        int i = 0;
        int j = words.length - 1;
        while( i <= j )
        {
            String temp = words[i];
            words[i++] = words[j];
            words[j--] = temp;
        }

        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for( int k = 0; k < n; k++ )
        {
            if( words[k].trim().length() > 0 )
                sb.append( words[k] + " " );

        }

        return sb.substring( 0, sb.length() - 1 );
    }
}

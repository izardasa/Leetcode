package Leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class GoatLatin
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        String str = s.nextLine();
        String res = toGoatLatin( str );
        System.out.println( res );
    }

    public static String toGoatLatin( String S )
    {
        HashSet<Character> vowels = new HashSet<Character>();
        for(Character c: "aeiouAEIOU".toCharArray())
        {
            vowels.add( c );
        }
        
        int index =1;
        String res = new String();
        for(String word: S.split( " " ))
        {
            if(index>1)
                res+=" ";
            
            char firstLetter = word.charAt( 0 );
            if(vowels.contains( firstLetter ))
            {
                res+=word+"ma";
            }
            else
            {
                res+=word.substring( 1 )+firstLetter+"ma";
            }
            
            for(int i=0;i<index;i++)
            {
                res+="a";
            }
            index++;
        }
        
        return res;
    }
}

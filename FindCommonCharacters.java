package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindCommonCharacters
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] listOfString = new String[n];
        for( int i = 0; i < listOfString.length; i++ )
        {
               listOfString[i] = s.next();
        }
        
        List<Character> listOfCommonChars = getCommonCharacters(listOfString);
        System.out.println( listOfCommonChars );
        
    }

    private static List<Character> getCommonCharacters( String[] listOfString )
    {
        int[] charFrequencies = new int[26];

        Arrays.fill( charFrequencies, Integer.MAX_VALUE );
        
        for(String s: listOfString)
        {
            int[] charFreq1 = new int[26];
            for( int i = 0; i < s.length(); i++ )
            {
                int c = s.charAt( i )-'a';
                charFreq1[c]++;
                
            }
            
            for(int i=0;i<26;i++)
            {
                charFrequencies[i] = Math.min( charFreq1[i], charFrequencies[i] );
            }
            
        }
        
        List<Character> listOfChars = new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            while(charFrequencies[i]-->0)
            listOfChars.add( (char)(i+'a') );
        }
        
        return listOfChars;
    }
}

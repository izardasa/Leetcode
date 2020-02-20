package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        String[] strs = new String[ n ];
        for( int i = 0; i < n; i++ )
            strs[i] = s.next();

        GroupAnagrams group = new GroupAnagrams();
        List<List<String>> groupAnagrams = group.groupAnagrams( strs );
        System.out.println( groupAnagrams );

    }

    public List<List<String>> groupAnagrams( String[] strs )
    {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for( int i = 0; i < strs.length; i++ )
        {
            char[] sortedChars = strs[i].toCharArray();
            Arrays.sort( sortedChars );
            String sortedStr = new String( sortedChars );

            if( !map.containsKey( sortedStr ) )
            {
                ArrayList<String> listStr = new ArrayList<>();
                map.put( sortedStr, listStr );
            }
          
                map.get( sortedStr ).add( strs[i] );
            
        }

        List<List<String>> res = new ArrayList<>();
        res.addAll( map.values() );

        return res;

    }

}

package Leetcode;

import java.util.HashMap;

public class FirstUniqueCharacter
{

    public static void main( String[] args )
    {
        String str = "loveleetcode";
        int firstUniqueChracterIndex = getFirstUniqueChracterIndex(str);
        System.out.println( firstUniqueChracterIndex );
    }

    private static int getFirstUniqueChracterIndex( String s )
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt( i );
            if(!map.containsKey( c ))
            {
                map.put( c, i);
            }
            else
            {
                map.put( c, Integer.MAX_VALUE );
            }
            
        }
        
        int minIndex = Integer.MAX_VALUE;
        for(int index: map.values())
        {
            if(minIndex>index)
                minIndex = index;
        }
        
        return minIndex==Integer.MAX_VALUE?-1:minIndex;
    }
}

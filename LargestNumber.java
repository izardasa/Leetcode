package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

class NumberComparator implements Comparator<String>
{

    @Override
    public int compare( String o1, String o2 )
    {
        String concat1 = o1+o2;
        String concat2 = o2+o1;
        return concat2.compareTo( concat1 );
    }
    
}
public class LargestNumber
{

    public String largestNumber( int[] nums )
    {
        String[] numStr = Arrays.stream( nums ).mapToObj( String:: valueOf ).toArray(String[]:: new);
        Arrays.sort( numStr, new NumberComparator());
     
        int countZero=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numStr.length;i++)
        {
            if(numStr[i].equals( "0"))
            {
                countZero++;
            }
            sb.append( numStr[i] );
        }
        
        if(countZero==numStr.length)
            return "0";
        
        return sb.toString();
    }

    public static void main( String[] args )
    {
        int[] nums = new int[] {3,30,34,5,9};
        LargestNumber largestNumber = new LargestNumber();
        
        System.out.println( largestNumber.largestNumber( nums ) );  
    }

}

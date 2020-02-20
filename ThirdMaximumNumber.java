package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class ThirdMaximumNumber
{
    public int thirdMax( int[] nums )
    {
        if( nums == null || nums.length == 0 )
            return 0;

        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for( Integer num : nums )
        {
            if( ( max != null && max.equals( num )) || ( secondMax != null && secondMax.equals( num ))
                || ( thirdMax != null && thirdMax.equals( num ) ))
                continue;

            if( max == null || num > max )
            {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }
            else if( secondMax == null || num > secondMax )
            {
                thirdMax = secondMax;
                secondMax = num;
            }
            else if( thirdMax == null || num > thirdMax )
            {
                thirdMax = num;
            }
        }

        if( secondMax == null || thirdMax == null )
            return max;

        return thirdMax;
    }

    public static void main( String[] args )
    {
        ThirdMaximumNumber obj = new ThirdMaximumNumber();
        System.out.println( obj.thirdMax( new int[] {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1} ) );
    }

}

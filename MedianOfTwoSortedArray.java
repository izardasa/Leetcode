package Leetcode;

import java.util.Stack;

public class MedianOfTwoSortedArray
{
    public static void main( String[] args )
    {
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
        System.out.println( medianOfTwoSortedArray.findMedianSortedArrays( new int[] {1, 2}, new int[]{3,4} ) );
    }

    public double findMedianSortedArrays( int[] nums1, int[] nums2 )
    {

        if( nums1.length > nums2.length )
            return findMedianSortedArrays( nums2, nums1 );
        int low = 0;
        int high = nums1.length ;
        double result = 0.0;
        while( low <= high )
        {
            int parX = ( high + low ) / 2;
            int parY = ( nums1.length + nums2.length + 1 ) / 2 - parX;

            int leftMaxX = parX == 0 ? Integer.MIN_VALUE : nums1[parX - 1];
            int rightMinX = parX == nums1.length ? Integer.MAX_VALUE : nums1[parX];
            int leftMaxY = parY == 0 ? Integer.MIN_VALUE : nums2[parY - 1];
            int rightMinY = parY == nums2.length ? Integer.MAX_VALUE : nums2[parY];

            int totalNums = nums1.length + nums2.length;

            if( leftMaxX <= rightMinY && leftMaxY <= rightMinX )
            {
                if( totalNums % 2 != 0 )
                {
                    result = Double.valueOf( Math.max( leftMaxX, leftMaxY ) );
                    break;
                }
                else
                {
                    result = ( Math.max( leftMaxX, leftMaxY ) + Math.min( rightMinX, rightMinY ) ) / 2.0;
                    break;
                }
            }

            if( leftMaxX > rightMinY )
            {
                high = parX - 1;
            }
            else
                low = parX + 1;

        }

        return result;
    }
}

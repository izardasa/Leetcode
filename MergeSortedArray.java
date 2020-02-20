package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MergeSortedArray
{
    public static void main( String[] args )
    {
        MergeSortedArray obj = new MergeSortedArray();
        int[] A = new int[]{1,2,6,0,0,0};
        int[] B = new int[]{1,2,3};
         obj.merge(A,3,B,3 ) ;
         System.out.println( Arrays.toString( A ) );
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null || nums2.length==0)
            return;
        
        int i=n-1;
        int j=n-1;
        
        int k = nums1.length-1;
        
        while(i>=0 && j>=0)
        {
            if(nums1[i]>=nums2[j])
            {
                nums1[k] = nums1[i];
                i--;
            }
            else
            {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        while(j>=0)
        {
            nums1[k--] = nums2[j--];
        }
    }
}

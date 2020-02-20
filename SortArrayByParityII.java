package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParityII
{
    public int[] sortArrayByParityII(int[] A) {
        if(A==null || A.length==0)
            return A;
        
        int l =0;
        int r = A.length-1;
        
        while(l<r)
        {
            while(l<r && ((l%2==0 && A[l]%2==0)|| (l%2==1 && A[l]%2==1)))
                l++;
            
            while(l<r && ((r%2==0 && A[r]%2==0)|| (r%2==1 && A[r]%2==1)))
                r--;
            
            if(l<r)
            {
                int temp = A[l];
                A[l++] = A[r];
                A[r--] = temp;
            }
            
        }
        
        return A;
    }

    public static void main( String[] args )
    {
        SortArrayByParityII obj = new SortArrayByParityII();
        System.out.println(Arrays.toString(  obj.sortArrayByParityII( new int[] {2,3,1,1,4,0,0,4,3,3} ) ));
    }

}

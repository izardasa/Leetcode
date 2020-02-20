package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInArray
{


    public static void main( String[] args )
    {
        List<Integer> result = new ArrayList();
        int[] nums= new int[] {4,3,2,7,8,2,3,1};
        for(int i=0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index] = -nums[index];
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                result.add(i+1);
        }
        
        for(int num: result)
            System.out.println( num );
        
        
    }

}

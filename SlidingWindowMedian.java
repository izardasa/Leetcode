package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SlidingWindowMedian {
    
    public static void main(String[] args)
    {
        double[] medianSlidingWindow = medianSlidingWindow(new int[] {1,4,2,3},4);
        
        for(double num: medianSlidingWindow)
            System.out.print( num + " ");
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n-k+1];
        if(nums==null || nums.length==0)
            return res;
            
        int resCount=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<k;i++)
            list.add(new Integer(nums[i]));
        
        Collections.sort(list);
        res[resCount++] = k%2==0?(list.get(k/2)+list.get(k/2-1))/2:list.get(k/2);
        for(int i=1;i<=n-k;i++)
        {
            list.remove(new Integer(nums[i-1]));
            list.add(new Integer(nums[i+k-1]));
            
            Collections.sort(list);
            
            if(k%2!=0)
                res[resCount++] = list.get(k/2);
            else
                res[resCount++] = (list.get(k/2-1)+list.get(k/2))/2.0;
                
        }
        
        return res;
    }
}
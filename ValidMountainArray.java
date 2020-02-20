package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ValidMountainArray
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );

        System.out.println( validMountainArray(new int[] {0,3,2,1}) );
    }

    public static boolean validMountainArray(int[] A) {
        if(A==null || A.length<3)
            return false;
          
          int i=0;
          while(i>=0 && i+1<A.length && A[i]<A[i+1])
              i++;
          
          if(i==0 || i==A.length-1)
              return false;
          
          while(i>=0 && i+1<A.length && A[i]>A[i+1])
              i++;  
          
          return i==A.length;
          
      }
}

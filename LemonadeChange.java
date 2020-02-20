package Leetcode;

import java.util.Scanner;

public class LemonadeChange
{

    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        int n = s.nextInt();
        int[] bills = new int[ n ];
        for( int i = 0; i < n; i++ )
        {
            bills[i] = s.nextInt();
        }

        boolean lemonadeChange = lemonadeChange( bills );
        System.out.println( lemonadeChange );
    }

    public static boolean lemonadeChange( int[] bills )
    {
        int fives =0;
        int tens = 0;
        for(Integer bill : bills)
        {
            if(bill==5)
            {
                fives++;
            }
            else if(bill==10)
            {
                tens++;
                fives--;
            }
            else if(tens>0)
            {
                tens--;
                fives--;
            }
            else
            {
               fives-=3; 
            }
            
            if(fives<0)
                return false;
        }
        return true;
    }

}

package Leetcode;

import java.util.List;
import java.util.Stack;

public class Maximum69Number
{
    public int maximum69Number (int num) {
        int temp = num;
        int count = 1;
        int max = 0;
        while (num > 0) {
            if (num % 10 == 6) {
                max = count;
            }
            count = count * 10;
            num = num / 10;
        }
        return temp += 3 * max;
    }

    public static void main( String[] args )
    {
        Maximum69Number obj = new Maximum69Number();
       System.out.println( obj.maximum69Number( 9669 ) );
    }

}

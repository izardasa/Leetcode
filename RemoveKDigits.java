package Leetcode;

import java.util.Stack;

public class RemoveKDigits
{
    public static void main( String[] args )
    {
        RemoveKDigits obj = new RemoveKDigits();
        System.out.println( obj.removeKdigits( "9", 1 ) );
    }

    public String removeKdigits(String num, int k) {
        int count=k;
        Stack<Integer> stack = new Stack();
        
        for(int i=0;i<num.length();i++)
        {
            int n = num.charAt(i)-'0';
            while(!stack.isEmpty() && n<stack.peek() && count>0)
            {
                stack.pop();
                count--;
            }
            
            stack.push(n);
        }
        
        while(count>0)
        {
            stack.pop();
            count--;
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
        {
            result.append(stack.pop());
        }
        
        result.reverse();
        while(result.length()>1 && result.charAt(0)=='0')
        {
            result.deleteCharAt(0);
        }
        
        
        if(result.length()==0)
            result.append( "0");
        return result.toString();
    }
}

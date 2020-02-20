package Leetcode;

import java.util.List;
import java.util.Stack;

public class VerifyingAnAlienDictionary
{
    public boolean isAlienSorted(String[] words, String order) {
        if(words==null || words.length<=1)
            return true;
        
        for(int i=1;i<words.length;i++)
        {
            String word1 = words[i-1];
            String word2 = words[i];
                
            if(!areOrdered(word1, word2, order))
                return false;
        }
        return true;
    }
    
    private boolean areOrdered(String s1, String s2, String order)
    {
        if(s1==null || s1.length()==0)
            return true;
        
        if(s2==null || s2.length()==0)
            return false;
        
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
                return order.indexOf(s1.charAt(i))<order.indexOf(s2.charAt(j));
        }
        
        return s1.length()==s2.length();
    }
    
    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(2 );
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
  
        VerifyingAnAlienDictionary obj = new VerifyingAnAlienDictionary();
        System.out.println( obj.isAlienSorted( new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz" ) );
    }

}

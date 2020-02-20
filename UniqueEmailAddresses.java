package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueEmailAddresses
{


    public static void main( String[] args )
    {
       
        UniqueEmailAddresses obj = new UniqueEmailAddresses();
        String[] emails = new String[] {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println( obj.numUniqueEmails( emails ) );
        
    }
    
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet();
        for(String email: emails)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<email.length();i++)
            {
                char c = email.charAt(i);
                if(c=='.')
                    continue;
                else if(c=='+')
                {
                    while(email.charAt(i)!='@')
                        i++;
                }
                else if(c!='@')
                    sb.append(c);
                
                if(email.charAt(i)=='@')
                {
                    sb.append(email.substring(i,email.length()));
                    break;
                }
            }
            uniqueEmails.add(sb.toString());
        }
        
        return uniqueEmails.size();
        
    }

}

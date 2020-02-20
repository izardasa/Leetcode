package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipGame
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner( System.in );
        List<String> moves = generatePossibleNextMoves( s.next() );
        
        for(String move: moves)
        {
            System.out.println( move );
        }

    }

    public static List<String> generatePossibleNextMoves(String s)
    {
        int i=0;
        List<String> possibleMoves= new ArrayList<String>();
        while(i<s.length())
        {
            int nextMove = i==0?s.indexOf( "++" ):s.indexOf( "++", i );
            if(nextMove==-1)
                return possibleMoves;
            //System.out.println( nextMove );
            i = nextMove+1;
            
            String move = s.substring( 0,nextMove )+"--"+s.substring( nextMove+2 );
            possibleMoves.add( move );
        }
        
        return possibleMoves;
    }
}
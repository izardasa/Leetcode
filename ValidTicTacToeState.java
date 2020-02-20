package Leetcode;

import java.util.Stack;

public class ValidTicTacToeState
{

    public boolean validTicTacToe(String[] board) {
        int oCount =0;
        int xCount=0;
        
        for(String row : board)
        {
            for(char move: row.toCharArray())
            {
                if(move=='O')
                    oCount++;
                else if(move=='X')
                    xCount++;
            }
        }
        
        System.out.print(xCount+" "+oCount);
      
        if(xCount!=oCount && oCount!=xCount-1) return false;
        if(hasWon(board, 'X') && oCount!=xCount-1) return false;
        if(hasWon(board, 'O') && xCount!=oCount) return false;
        
        return true;
    }
    
    private boolean hasWon(String[] board, char p)
    {
        for(int i=0;i<3;i++)
        {
           if(p == board[0].charAt(i) && p == board[1].charAt(i) && p==board[2].charAt(i)) return true;
            
            if(p==board[i].charAt(0) && p==board[i].charAt(1) && p==board[i].charAt(2)) return true;
        }
        
        if(p==board[0].charAt(0) && p==board[1].charAt(1) && p==board[2].charAt(2)) return true;
        if(p==board[0].charAt(2) && p==board[1].charAt(1) && p==board[2].charAt(0)) return true;
        
        return false;
    }
    
    public static void main( String[] args )
    {

        ValidTicTacToeState obj = new ValidTicTacToeState();
        String[] board = {"XXX","OOX","OOX"};
        System.out.println( obj.validTicTacToe( board ) );
    }

}

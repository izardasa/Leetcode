package Leetcode;

public class IntegerToEnglishWords
{

    public static void main( String[] args )
    {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        System.out.println( integerToEnglishWords.numberToWords( 1000 ) );

    }

    public String numberToWords( int num )
    {
        String res = "";
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;

        if( num == 0 )
            return "Zero";
        if( num / billion > 0 )
        {
            if(res.length()!=0)
                res+=" ";
            res += hundred( num / billion ) + " Billion";
            num = num % billion;

        }

        if( num / million > 0 )
        {
            if(res.length()!=0)
                res+=" ";
            res += hundred( num / million ) + " Million";
            num %= million;
        }

        if( num / thousand > 0 )
        {
            if(res.length()!=0)
                res+=" ";
            res += hundred( num / thousand ) + " Thousand";
            num %= thousand;
        }

         if(res.length()!=0 && num>0)
                res+=" ";
        res += hundred( num );

        return res;

    }

    private String hundred( int num )
    {
        String res = "";
        int hundred = 100;

        if( num / hundred > 0 )
        {
            if(res.length()!=0)
                res+=" ";
            
            res += ones( num / hundred ) + " Hundred";
            num %= hundred;
        }

        if( num > 20 )
        {
            if(res.length()!=0)
                res+=" ";
            
            
            res += tens( num / 10 );
            num %= 10;
        }

        if( num >= 1 && num <= 9 )
        {
            if(res.length()!=0)
                res+=" ";
            res += ones( num );
        }

        if( num >= 11 && num <= 19 )
        {
            if(res.length()!=0)
                res+=" ";
            res += elevenToNineteen( num );
        }

        if( num % 10 == 0 && num>0)
        {
            if(res.length()!=0)
                res+=" ";
            res += tens( num / 10 );
        }
        return res;
    }

    private String ones( int num )
    {
        String res = "";
        switch( num )
        {
            case 1:
                res = "One";
                break;
            case 2:
                res = "Two";
                break;
            case 3:
                res = "Three";
                break;
            case 4:
                res = "Four";
                break;
            case 5:
                res = "Five";
                break;
            case 6:
                res = "Six";
                break;
            case 7:
                res = "Seven";
                break;
            case 8:
                res = "Eight";
                break;
            case 9:
                res = "Nine";
                break;

        }
        return res;
    }

    private String elevenToNineteen( int num )
    {
        String res = "";
        switch( num )
        {
            case 11:
                res = "Eleven";
                break;
            case 12:
                res = "Twelve";
                break;
            case 13:
                res = "Thirteen";
                break;
            case 14:
                res = "Fourteen";
                break;
            case 15:
                res = "Fifteen";
                break;
            case 16:
                res = "Sixteen";
                break;
            case 17:
                res = "Seventeen";
                break;
            case 18:
                res = "Eighteen";
                break;
            case 19:
                res = "Nineteen";
                break;
        }
        return res;
    }

    private String tens( int num )
    {
        String res = "";
        switch( num )
        {
            case 1:
                res = "Ten";
                break;
            case 2:
                res = "Twenty";
                break;
            case 3:
                res = "Thirty";
                break;
            case 4:
                res = "Forty";
                break;
            case 5:
                res = "Fifty";
                break;
            case 6:
                res = "Sixty";
                break;
            case 7:
                res = "Seventy";
                break;
            case 8:
                res = "Eighty";
                break;
            case 9:
                res = "Ninety";
                break;

        }
        return res;
    }
}

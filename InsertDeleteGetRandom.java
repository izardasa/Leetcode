package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom
{
    HashMap<Integer, Integer> indexMap;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom()
    {
        list = new ArrayList();
        indexMap = new HashMap();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert( int val )
    {
        if( indexMap.containsKey( val ) )
            return false;

        list.add( val );
        indexMap.put( val, list.size() - 1 );
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove( int val )
    {
        if( !indexMap.containsKey( val ) )
            return false;

        int size = list.size();
        int index = indexMap.get( val );
        int temp = list.get( size - 1 );
        list.set( index, temp );
        indexMap.put( temp, index );
        list.remove( size - 1 );
        indexMap.remove( val );
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom()
    {
        Random rand = new Random();
        if(list.size()==0)
            return -1;
        int randomIndex = rand.nextInt( list.size() );
        return list.get( randomIndex );
    }

    public static void main( String[] args )
    {
        InsertDeleteGetRandom insertDeleteGetRandom = new InsertDeleteGetRandom();
        System.out.println( insertDeleteGetRandom.insert( 0 ));
        System.out.println( insertDeleteGetRandom.remove( 0 ));
        System.out.println( insertDeleteGetRandom.insert( 0 ));
        System.out.println( insertDeleteGetRandom.remove( 0 ));
        System.out.println( insertDeleteGetRandom.getRandom());

    }

}

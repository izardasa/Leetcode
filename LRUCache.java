package Leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache
{
    private int capacity;
    HashMap<Integer, Node> nodeMap;
    private final Node head = new Node();
    private final Node tail = new Node();
    int size = 0;

    public LRUCache( int capacity )
    {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    public int get( int key )
    {
        int result =-1;
        Node node = nodeMap.get( key );
        
        if(null!=node)
        {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;

    }

    public void put( int key, int value )
    {
        Node node = nodeMap.get( key );
        if( node != null )
        {
            remove( node );
            node.val = value;
            add( node );
        }
        else
        {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            if( nodeMap.size() == capacity )
            {
                nodeMap.remove( tail.pre.key );
                remove( tail.pre );
            }
            add( newNode );
            nodeMap.put( key, newNode );
        }
    }

    private void add( Node node )
    {
        Node headNext = head.next;
        node.next = headNext;
        node.pre = head;
        head.next = node;
        headNext.pre = node;
    }

    private void remove( Node node )
    {
        Node nextNode = node.next;
        Node preNode = node.pre;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    public static void main( String[] args )
    {
        LRUCache lruCache = new LRUCache( 3 );
        lruCache.put( 1, 1 );
        lruCache.put( 2, 2 );
        lruCache.put( 3, 3 );
        lruCache.put( 4, 4 );
        lruCache.put( 5, 5 );
    }

    class Node
    {
        Node next;
        Node pre;
        int val;
        int key;
    }
}

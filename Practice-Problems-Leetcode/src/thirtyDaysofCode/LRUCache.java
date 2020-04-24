package thirtyDaysofCode;

import java.util.*;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(  capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
  */

public class LRUCache {

	
	    class DLNode {
	        int key;
	        int value;
	        DLNode prev;
	        DLNode next;
	    }
	   
	    private HashMap<Integer, DLNode> cache = new HashMap<>();
	    private int size;
	    private int capacity;
	    private DLNode head;
	    private DLNode tail;
	    
	    private void addNode(DLNode node) {
	        
	        /*lets always add new node after the virtual head*/
	        node.prev = head;
	        node.next = head.next;
	        
	        head.next.prev = node;
	        head.next = node;
	    }
	    
	    private void removeNode(DLNode node) {
	        
	        DLNode prev = node.prev;
	        DLNode next = node.next;
	        
	        prev.next = next;
	        next.prev = prev;
	    }
	    
	    private void moveToHead(DLNode node) {
	        
	        removeNode(node);
	        addNode(node);
	    }
	    
	    private DLNode popTail() {
	        DLNode res = tail.prev;
	        removeNode(res);
	        return res;
	    }
	       
	    public LRUCache(int capacity) {
	        this.size = 0;
	        this.capacity = capacity;
	        
	        head = new DLNode();
	        tail = new DLNode();
	        head.next = tail;
	        tail.prev = head;
	    }
	    
	    public int get(int key) {
	        
	        DLNode node = cache.get(key);
	        if (node == null) return -1;
	        
	        // add to node to head as it has been just accessed!
	        moveToHead(node);
	 
	        return node.value;
	        
	    }
	    
	    public void put(int key, int value) {
	        DLNode node = cache.get(key);
	        
	        if (node == null) {
	            
	            DLNode newNode = new DLNode();
	            newNode.key = key;
	            newNode.value = value;
	            
	            cache.put(key,newNode);
	            addNode(newNode);
	            
	            ++size;
	            
	            if (size > capacity) {
	                DLNode tail = popTail();
	                cache.remove(tail.key);
	                size--;
	            }
	        } else {
	            node.value = value;
	            moveToHead(node);
	        }
	    }
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */



package thirtyDaysofCode;

import java.util.*;

/**
 * 
 * First Unique Number
 * 
 * You have a queue of integers, you need to retrieve the first unique integer
 * in the queue.
 * 
 * Implement the FirstUnique class:
 * 
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the
 * queue, and returns -1 if there is no such integer. void add(int value) insert
 * value to the queue.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]] Output: [null,2,null,2,null,3,null,-1]
 * 
 * Explanation: FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2 firstUnique.add(5); // the queue
 * is now [2,3,5,5] firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2); // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3 firstUnique.add(3); // the queue
 * is now [2,3,5,5,2,3] firstUnique.showFirstUnique(); // return -1
 * 
 */

class FirstUnique {

	private class ListNode {

		ListNode _prev;
		ListNode _next;
		int _val;

		public ListNode(int val) {
			_val = val;
			_prev = null;
			_next = null;

		}
	}

	private class MyDLL {

		private ListNode _head;
		private ListNode _tail;

		public MyDLL() {
			_head = new ListNode(-1);
			_tail = new ListNode(-1);

			_head._next = _tail;
			_tail._prev = _head;
		}

		public ListNode getFirst() {
			return _head._next;
		}

		public boolean isEmpty() {
			return _head._next == _tail;
		}

		public void remove(ListNode node) {
			ListNode prev = node._prev;
			ListNode next = node._next;

			prev._next = next;
			next._prev = prev;
		}

		public ListNode append(int num) {
			ListNode node = new ListNode(num);
			_tail._prev._next = node;
			node._prev = _tail._prev;
			node._next = _tail;
			_tail._prev = node;

			return node;
		}
	}

	private Map<Integer, ListNode> _map;
	private MyDLL _keys;

	public FirstUnique(int[] nums) {

		_keys = new MyDLL();
		_map = new HashMap<>();

		for (int num : nums) {
			add(num);
		}
	}

	public int showFirstUnique() {
		return _keys.isEmpty() == true ? -1 : _keys.getFirst()._val;
	}

	public void add(int value) {
		if (_map.containsKey(value)) {
			if (_map.get(value) != null) {
				_keys.remove(_map.get(value));
				_map.put(value, null);
			}
		} else {
			_map.put(value, _keys.append(value));
		}

	}

	/**
	 * Your FirstUnique object will be instantiated and called as such: FirstUnique
	 * obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
	 * obj.add(value);
	 */

}

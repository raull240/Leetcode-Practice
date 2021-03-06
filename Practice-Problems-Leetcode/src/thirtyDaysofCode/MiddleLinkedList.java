package thirtyDaysofCode;

import helper.LinkedList;
import helper.LinkedList.ListNode;

/**
 * @author rahulrao
 * 
 *         Definition for singly-linked list. public class ListNode { int val;
 *         ListNode next; ListNode(int x) { val = x; } }
 */

public class MiddleLinkedList {

	public ListNode middleNode(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null)
			return slow.next;
		return slow;

	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list = LinkedList.insert(list, 1);
		list = LinkedList.insert(list, 2);
		list = LinkedList.insert(list, 3);
		list = LinkedList.insert(list, 4);
		list = LinkedList.insert(list, 5);
		list = LinkedList.insert(list, 6);
		list = LinkedList.insert(list, 7);
		list = LinkedList.insert(list, 8);
		list = LinkedList.insertBefore(list, 2, 88);
		LinkedList.printList(list.Head);
		ListNode result = new MiddleLinkedList().middleNode(list.Head);
		LinkedList.printList(result);

	}

}

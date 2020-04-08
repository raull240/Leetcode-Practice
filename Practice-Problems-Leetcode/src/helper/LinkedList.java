package helper;

public class LinkedList {

	public static ListNode Head;

	public static class ListNode {

		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}

	}

	public static LinkedList insert(LinkedList list, int data) {

		// create a new node given the data
		ListNode new_node = new ListNode(data);
		new_node.next = null;

		// if there is no list , make one
		if (list.Head == null) {
			list.Head = new_node;
		}

		// if not, go till the end of the list to place the new node
		else {

			ListNode end = list.Head;

			while (end.next != null) {
				end = end.next;
			}
			end.next = new_node;

		}
		return list;

	}

	public static void printList(ListNode list) {

		ListNode currNode = list;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static LinkedList insertBefore(LinkedList list, int key, int value) {

		ListNode place_in_list = new ListNode(value);
		place_in_list.next = null;
		if (list.Head != null) {

			ListNode curr = list.Head;
			ListNode prev = new ListNode(-1);
			prev.next = curr;

			while (curr != null) {
				if (curr.val != key) {
					curr = curr.next;
					prev = prev.next;
				} else {

					prev.next = place_in_list;
					place_in_list.next = curr;

					if (list.Head.val == key) {
						list.Head = place_in_list;
					}

					break;
				}

			}
		}

		return list;
	}

}

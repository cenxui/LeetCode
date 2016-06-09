package list;

import java.util.Stack;

public class ListUtil {
	/**
	 * get the list range {@value from} between {@value to}
	 * 
	 * @param from
	 *            the head node value
	 * @param to
	 *            the last node value
	 * @return the list
	 */

	public static ListNode getListNode(int from, int to) {
		ListNode listNode = new ListNode(from);
		ListNode addNode;
		ListNode endNode = listNode;
		for (int i = from + 1; i < to; i++) {
			addNode = new ListNode(i);
			endNode.next = addNode;
			endNode = endNode.next;
		}
		return listNode;
	}

	/**
	 * remove all elements node equal val in head
	 * 
	 * @param head
	 *            the listNode we want to check
	 * @param val
	 *            the value we want to remove
	 * @return the list node with no node value equal val
	 */

	public static ListNode removeElements(ListNode head, int val) {
		ListNode result = head;
		if (result == null) {
			return result;
		}
		while (head.next != null) {
			if (head.next.val == val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}

		if (result.val == val && result.next == null) {
			result = null;
			return result;
		}

		if (result.val == val && result.next != null) {
			result.val = result.next.val;
			result.next = result.next.next;
		}

		return result;
	}

	/**
	 * rotate to right
	 * 
	 * @param head
	 *            the list we want to rotate
	 * @param k
	 *            the step we want
	 * @return the list rotated
	 */

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode check = head;
		ListNode rotate = head;
		ListNode lastNode = head;
		if (k == 0) {
			return check;
		}

		if (head == null) {
			return check;
		}

		int floor = 0;
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.push(head);
			lastNode = head;
			head = head.next;
			floor++;
		}
		k = k % floor;
		for (int i = 0; i < k; i++) {
			rotate = stack.pop();
		}
		lastNode.next = check;
		stack.pop().next = null;

		return rotate;
	}
	
	/**
	 * delete node in list node
	 * @param node 
	 * 		the list node we want to remove
	 */

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	/**
	 * add node in list node
	 * @param node {@value addNode} next to this node
	 * @param addNode 
	 */

	public static void addNode(ListNode node, ListNode addNode) {
		ListNode listNode = node.next;
		node.next = addNode;
		addNode.next = listNode;
	}

	/**
	 * print the given list node to the last list node
	 * 
	 * @param listNode
	 *            the head list node
	 */

	public static void printLisNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}

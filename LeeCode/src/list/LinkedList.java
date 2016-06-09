package list;

import java.util.Stack;

import org.junit.Ignore;

public class LinkedList {

	public static void main(String[] args) {

		ListNode listNode = getListNode(1, 3);
		listNode.next.val = 1;
		printLisNode(listNode);
		System.out.println("isPalindrome");
		System.out.println(isPalindrome(listNode));
		
	}

	/**
	 * 
	 * @param head
	 * @return
	 */

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		int depth = 1;
		ListNode checkNode = head;
		Stack<Integer> stack = new Stack<>();

		while (checkNode != null) {
			stack.push(checkNode.val);
			depth++;
			checkNode = checkNode.next;
		}
		checkNode = head;

		for (int i = 0; i < depth / 2; i++) {
			if (stack.pop() != checkNode.val) {
				return false;
			}
			checkNode = checkNode.next;
		}
		return true;
	}

	/**
	 * swap pairs in list node
	 * 
	 * @param head
	 *            the list node we want to swap
	 * @return the list swapped
	 */

	public static ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode resultNode = head.next;// build the first link node
		ListNode tailNode = head.next.next;// restore third node
		resultNode.next = head;// exchange first node to second node
		resultNode.next.next = tailNode;// get back third node
		ListNode headNode = resultNode.next; // restore the link Node
		head = tailNode; // get the next link node

		ListNode swapListNode;
		while (head != null && head.next != null) {
			tailNode = head.next.next; // restore third node
			swapListNode = head;// restore first node
			headNode.next = head.next; // previously second node to be first
										// node
			headNode.next.next = swapListNode; // previously first node to be
												// second node
			headNode.next.next.next = tailNode;// get back third node

			headNode = head;// restore
			head = tailNode;// third node is the next exchange node
		}

		return resultNode;
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
	 * this method with low efficiency and need to be improve to be accepted
	 * @param head
	 * @return 
	 */

	public static boolean hasCycle(ListNode head) {
		ListNode check = head;

		while (head != null) {
			head = head.next;
			if (head == check) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	/**
	 * still need to program
	 * 
	 * @param listNode
	 * @return
	 */
	@Ignore
	public static ListNode getCycleListNode(ListNode listNode) {
		return null;
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
	 * 
	 * @param head
	 *            input linked list
	 * @return the reverse linked list
	 */

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode resultNode = new ListNode(head.val);
		ListNode tempNode;
		while (head.next != null) {
			head = head.next;
			tempNode = resultNode;
			resultNode = new ListNode(head.val);
			resultNode.next = tempNode;
		}
		return resultNode;
	}

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void addNode(ListNode node, ListNode addNode) {
		ListNode listNode = node.next;
		node.next = addNode;
		addNode.next = listNode;
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode oddListNode = head;
		if (head.next == null) {
			return oddListNode;
		}

		if (head.next.next == null) {
			return oddListNode;
		}

		ListNode evenNode;
		evenNode = new ListNode(head.next.val);

		ListNode evenListNode = evenNode;

		head.next = head.next.next;
		head = head.next;

		while (head.next != null) {
			evenNode.next = new ListNode(head.next.val);
			evenNode = evenNode.next;
			if (head.next.next == null) {
				break;
			}
			head.next = head.next.next;
			head = head.next;
		}
		head.next = evenListNode;
		return oddListNode;
	}

	/**
	 * deletDuplicates ListNode
	 * 
	 * @param head
	 * @return deletDuplicates ListNod
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode resultNode = head;
		ListNode checkNode;
		int headValue;

		while (head != null) {
			headValue = head.val;
			checkNode = head;
			while (checkNode != null && headValue == checkNode.val) {
				checkNode = checkNode.next;
			}
			head.next = checkNode;
			head = head.next;
		}

		return resultNode;
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
	 * This class is for the list node structure
	 * 
	 * @author xenxui
	 *
	 */

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

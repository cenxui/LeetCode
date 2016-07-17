package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Ignore;

/**
 * 
 * @author xenxui
 * @since 2016/5/30
 */
public class LinkedList {
	
	public static void main(String[] args) {

		ListNode listNode = ListUtil.getListNode(1, 8);
		
		System.out.println("removeNthFromEnd");
		
		removeNthFromEnd(listNode,1);
		
		ListUtil.printLisNode(listNode);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		if (n <= 0) {
			return head;
		}

		List<ListNode> resultList = new ArrayList<>();
		while (head != null) {
			resultList.add(head);
			head = head.next;
		}
		
		

		int length = resultList.size();
		if (length < n) {
			return resultList.get(0);
		}

		if (length == 1 && n == 1) {
			return null;
		}
		
		if (n == 1) {
			resultList.get(length-2).next = null;
			return resultList.get(0);
		}
		
		if (length == 2 && n == 2) {		
			return resultList.get(1);
		}
		

		if (length == n) {
			resultList.get(0).val = resultList.get(1).val;
			resultList.get(0).next = resultList.get(2);
			return resultList.get(0);
		}

		resultList.get(length - n - 1).next = resultList.get(length - n + 1);

		return resultList.get(0);
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
	 * this method with low efficiency and need to be improve to be accepted
	 * 
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
}

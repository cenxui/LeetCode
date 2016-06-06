package number;

import java.util.Stack;

public class LinkedList {

	public static void main(String[] args) {

		ListNode listNode = getListNode(1, 3);
//		 printLisNode(listNode);
		
		printLisNode(rotateRight(listNode,1));
	}
	
	/**
	 * rotate to right
	 * @param head the list we want to rotate
	 * @param k the step we want
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
        k = k%floor;
        for (int i = 0;i < k; i++) {
        	rotate = stack.pop();
        }
        lastNode.next = check;
        stack.pop().next = null;
     
        return rotate;
    }

	/**
	 * 
	 * @param head input linked list
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

		while (head!= null) {
			headValue = head.val;
			checkNode = head;
			while (checkNode != null&& headValue == checkNode.val ) {
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
	 * 
	 * @param from
	 * @param to
	 * @return
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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

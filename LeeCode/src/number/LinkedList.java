package number;

public class LinkedList {

	public static void main(String[] args) {
		
		ListNode listNode = getListNode(1, 6);
//		printLisNode(listNode);
		ListNode resultNode = oddEvenList(listNode);
		printLisNode(resultNode);
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
	
	public static void addNode(ListNode node , ListNode addNode ) {
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
	
	public static void printLisNode(ListNode listNode) {
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	
	public static ListNode getListNode(int from, int to) {
		ListNode listNode = new ListNode(1);
		ListNode addNode;
		ListNode endNode = listNode;
		for (int i = from+1; i<to ;i++) {
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

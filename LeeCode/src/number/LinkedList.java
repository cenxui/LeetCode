package number;

public class LinkedList {

	public static void main(String[] args) {
		

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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

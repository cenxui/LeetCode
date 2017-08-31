package list;

/**
 * This class is for the list node structure
 * 
 * @author xenxui
 *
 */

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
//
//	@Override
//	public String toString() {
//		StringBuilder result = new StringBuilder();
//		result.append("->").append(this.val);
//
//		if (this.next != null) {
//			result.append(this.next);
//		}
//
//		return result.toString();
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof ListNode) {
			if (this.val != ((ListNode) obj).val)
				return false;

			if (this.next != null)
				return next.equals(((ListNode) obj).next);

			if (this.next == null && ((ListNode) obj).next == null)
				return true;
		}

		return false;
	}
}

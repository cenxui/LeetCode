package list;

public class ListNodeBuilder {
	private ListNode mListNode;
	private ListNode mTailNode;
	
	public ListNodeBuilder append(int val) {
		if (mListNode == null) {
			mListNode = new ListNode(val);
			mTailNode = mListNode;
		}else {
			mTailNode.next  = new ListNode(val);
			mTailNode = mTailNode.next;
		}
		return this;
	}
	
	public ListNode getListNode() {
		return mListNode;
	}
}

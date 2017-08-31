package list;

/**
 * useful to to create customized list node
 * 
 * @author xenxui 2016/6/9
 */
public class ListNodeBuilder {
	private ListNode mListNode;
	private ListNode mTailNode;

	/**
	 * add value to next node
	 * 
	 * @param val
	 *            The value you want to add .
	 * @return The list node head
	 */
	public ListNodeBuilder append(int val) {
		if (mListNode == null) {
			mListNode = new ListNode(val);
			mTailNode = mListNode;
		} else {
			mTailNode.next = new ListNode(val);
			mTailNode = mTailNode.next;
		}
		return this;
	}

	public ListNode toListNode() {
		return mListNode;
	}
}

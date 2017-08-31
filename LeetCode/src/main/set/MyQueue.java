package set;

public class MyQueue {

	private Queue head;
	private Queue tail;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void push(int x) {
		if (head == null) {
			head = new Queue();
			head.val = x;
			tail = head;
		} else {
			tail.next = new Queue();
			tail = tail.next;
			tail.val = x;
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		head = head.next;
	}

	// Get the front element.
	public int peek() {
		return head.val;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	private class Queue {
		int val;
		Queue next;
	}
}

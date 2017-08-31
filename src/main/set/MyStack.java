package set;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	private int count = 0;
	private int top = 0;
	private Queue<Integer> mQueue = new LinkedList<>();

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(10);
		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.top());
		System.out.println(myStack.empty());
		myStack.pop();
		System.out.println(myStack.empty());
	}

	// Push element x onto stack.
	public void push(int x) {
		count++;
		mQueue.add(x);
		top = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (count == 0) {
			return;
		}
		count--;
		Queue<Integer> queue = mQueue;
		mQueue = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			top = queue.poll();
			mQueue.add(top);

		}
	}

	// Get the top element.
	public int top() {
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return count == 0 ? true : false;
	}
}

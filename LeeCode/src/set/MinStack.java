package set;

public class MinStack {
	private Stack mStack;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public MinStack() {

	}

	public void push(int x) {
		Stack stack = new Stack();
		stack.value = x;
		if (mStack == null) {
			mStack = stack;
		} else {
			stack.stack = mStack;
			mStack = stack;
		}
	}

	public void pop() {
		if (mStack != null) {
			mStack = mStack.stack;
		}
	}

	public int top() {
		if (mStack != null) {
			return mStack.value;
		}
		return 0;
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		Stack stack = mStack;
		while (stack != null) {
			if (stack.value < min) {
				min = stack.value;
			}
			stack = stack.stack;
		}

		return min;
	}

	private class Stack {
		private int value;
		private Stack stack;
	}
}

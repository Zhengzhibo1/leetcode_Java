import java.util.Stack;

public class MyQueue {

// ====================算法实现======================
	private Stack<Integer> stack1 = null;
	private Stack<Integer> stack2 = null;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack2.push(x);
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}

	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		int result = stack1.peek();
		stack1.pop();

		return result;
	}

	/** Get the front element. */
	public int peek() {
		return stack1.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty();
	}
}

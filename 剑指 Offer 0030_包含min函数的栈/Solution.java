import java.util.Stack;

public class MinStack {
	// 双栈，stack2为辅助栈，存放最小值
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	/** initialize your data structure here. */
	public MinStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int x) {

		stack1.push(x);
		if (stack2.isEmpty() || x <= stack2.peek()) {
			stack2.push(x);
		}
	}

	public void pop() {

		int temp = stack1.pop();
		if (stack2.peek() == temp) {
			stack2.pop();
		}
	}

	public int top() {

		return stack1.peek();
	}

	public int min() {

		return stack2.peek();
	}

}

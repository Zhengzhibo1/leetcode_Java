import java.util.Stack;

public class MinStack {

	// 1 辅助栈
	// 时间复杂度O(1)
	// 空间复杂度O(n)
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public MinStack() {

	}

	public void push(int x) {

		stack1.push(x);
		stack2.push(Math.min(stack2.peek(), x));
	}

	public void pop() {

		stack1.pop();
		stack2.pop();
	}

	public int top() {
		return stack1.peek();
	}

	public int getMin() {
		return stack2.peek();
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-3);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());

	}

}

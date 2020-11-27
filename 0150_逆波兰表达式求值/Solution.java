import java.util.Stack;

public class Solution {

// ====================算法实现====================
	// 方法1 栈
	// 时间复杂度O(n)，n为数组长度
	// 空间复杂度O(n)
	public int evalRPN(String[] tokens) {

		// 边界条件判断，如果数组是空，则返回0
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		// 创建栈
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; ++i) {
			if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				Integer temp1, temp2;
				switch (tokens[i]) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					// 减法需要注意减数与被减数的区别
					temp1 = stack.pop();
					temp2 = stack.pop();
					stack.push(temp2 - temp1);
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					// 除法需要注意除数与被除数
					temp1 = stack.pop();
					temp2 = stack.pop();
					stack.push(temp2 / temp1);
					break;
				}
			}
		}

		return stack.pop();
	}

	// 方法2 数组模拟栈
	// 时间复杂度O(n)，n为数组长度
	// 空间复杂度O(n)
	// 注意：本质上和栈的实现没什么区别，但用数组会比栈的运行时间快
	// 方法2相当于方法1的优化
	public int evalRPN2(String[] tokens) {

		// 边界条件判断，如果数组是空，则返回0
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		// 栈数组大小为输入数组大小的一半，因为至少有一半是运算符，不需要存入栈数组中
		int stack[] = new int[(tokens.length >> 1) + 1];
		// 栈索引
		int index = 0;
		for (int i = 0; i < tokens.length; ++i) {
			switch (tokens[i]) {
			case "+":
				stack[index - 2] += stack[--index];
				break;
			case "-":
				stack[index - 2] -= stack[--index];
				break;
			case "*":
				stack[index - 2] *= stack[--index];
				break;
			case "/":
				stack[index - 2] /= stack[--index];
				break;
			default:
				// parseInt比valueOf效率高，因为减少自动拆箱装箱操作
				stack[index++] = Integer.parseInt(tokens[i]);
				break;
			}
		}
		return stack[0];
	}

// ====================测试代码====================
	public void test() {
		String tokens[] = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		int result = evalRPN(tokens);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

import java.util.Stack;

public class Solution {

// ===================算法实现======================
	// 方法 栈 + 遍历字符串
	// 时间复杂度O(n)，n为字符串的长度
	// 空间复杂度O(n)
	public int calculate(String s) {

		Stack<Integer> stack = new Stack<Integer>();

		int result = 0;
		int operand = 0;
		int sign = 1;

		for (int i = 0; i < s.length(); ++i) {

			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				operand = operand * 10 + c - '0';
			} else if (c == '+') {
				result += sign * operand;
				sign = 1;
				operand = 0;
			} else if (c == '-') {
				result += sign * operand;
				sign = -1;
				operand = 0;
			} else if (c == '(') {
				stack.add(result);
				stack.add(sign);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				result += sign * operand;
				sign = 1;
				operand = 0;

				result *= stack.pop();
				result += stack.pop();
			}
		}

		return result;
	}

// ===================测试代码======================
	public void test() {
		String s = "(1+(4+5+2)-3)+(6+8)";
		int result = calculate(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

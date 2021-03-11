import java.util.Stack;

public class Solution {

// ===================算法实现==========================
	// 方法 辅助栈
	// 时间复杂度O(n)，n为s的长度
	// 空间复杂度O(n)
	public int calculate(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0) {
			return 0;
		}

		// 存放临时结果
		Stack<Integer> stack = new Stack<Integer>();

		// 当前数字的前符号，第一个数字前符号默认为+
		char preSign = '+';

		int length = s.length();
		// 存放数字
		int num = 0;
		for (int i = 0; i < length; ++i) {

			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}

			if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == length - 1) {
				switch (preSign) {
				case '+':
					stack.add(num);
					break;
				case '-':
					stack.add(-num);
					break;
				case '*':
					stack.add(stack.pop() * num);
					break;
				default:
					stack.add(stack.pop() / num);
					break;
				}
				preSign = s.charAt(i);
				// 当前数字处理完毕，清零
				num = 0;
			}
		}

		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}

		return ans;
	}

// ===================测试代码==========================
	public void test() {
		String s = "3 + 5 / 2";
		int result = calculate(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

// ====================算法实现======================
	// 1 栈
	// 碰到']'时，将字符和数字出栈，组成新的组合之后入栈
	// 时间复杂度O(S + s)，s为原字符串长度，S为解码后字符串长度
	// 空间复杂度O(S)
	public String decodeString(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}

		Stack<Character> stack = new Stack<Character>();

		int index = 0;
		while (index < s.length()) {
			char temp = s.charAt(index);
			if (temp == ']') {
				// 取字符
				Stack<Character> str = new Stack<Character>();
				while (stack.peek() != '[') {
					str.add(stack.pop());
				}
				stack.pop();

				// 取数字
				Stack<Character> nums = new Stack<Character>();
				while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
					nums.add(stack.pop());
				}

				int count = 0;
				while (!nums.isEmpty()) {
					count = count * 10 + nums.pop() - '0';
				}

				// 再次入栈
				List<Character> list = new ArrayList<Character>();
				while (!str.isEmpty()) {
					list.add(str.pop());
				}

				for (int i = 0; i < count; ++i) {
					for (int j = 0; j < list.size(); ++j) {
						stack.add(list.get(j));
					}
				}
			} else {
				stack.add(temp);
			}

			index++;
		}

		int length = stack.size();
		char[] chars = new char[length];
		for (int i = length - 1; i >= 0; --i) {
			chars[i] = stack.pop();
		}

		return String.valueOf(chars);
	}

// ====================测试代码======================
	public void test1() {
		String s = "3[a]2[bc]";
		String result = decodeString(s);
		System.out.println(result);
	}

	public void test2() {
		String s = "3[a2[c]]";
		String result = decodeString(s);
		System.out.println(result);
	}

	public void test3() {
		String s = "100[leetcode]";
		String result = decodeString(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();
//		s.test3();
	}

}

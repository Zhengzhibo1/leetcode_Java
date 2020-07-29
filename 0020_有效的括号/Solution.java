import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	private Map<Character, Character> map = new HashMap<Character, Character>();

	public Solution() {
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
	}

// ====================算法实现==================
	// 1 栈
	// 时间复杂度O(n)，n为s的长度
	// 空间复杂度O(n)，最坏情况全是左括号
	public boolean isValid(String s) {

		if ((s.length() & 1) == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); ++i) {
			char temp = s.charAt(i);
			if (map.containsKey(temp)) {
				char top = stack.isEmpty() ? '#' : stack.pop();
				if (top != map.get(temp)) {
					return false;
				}
			} else {
				stack.add(temp);
			}
		}

		return stack.isEmpty();
	}

// ====================测试代码==================
	public void test() {
		String s = "{[]}";
		boolean result = isValid(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

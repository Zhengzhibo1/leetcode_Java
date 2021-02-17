import java.util.Deque;
import java.util.LinkedList;

public class Solution {

// ===================算法实现=====================
	// 方法 贪心 + 栈
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String removeKdigits(String num, int k) {

		Deque<Character> deque = new LinkedList<Character>();
		int length = num.length();
		for (int i = 0; i < length; ++i) {
			char c = num.charAt(i);

			while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
				deque.removeLast();
				k--;
			}

			deque.addLast(c);
		}

		for (int i = 0; i < k; ++i) {
			deque.removeLast();
		}

		boolean lead = true;
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {

			char c = deque.removeFirst();
			if (lead && c == '0') {
				continue;
			}

			lead = false;
			sb.append(c);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}

// ===================测试代码=====================
	public void test() {
		String num = "1432219";
		int k = 3;
		String result = removeKdigits(num, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

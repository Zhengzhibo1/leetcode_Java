import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

// ===================算法实现=====================
	// 方法 贪心 + 栈
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public String removeDuplicateLetters(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int length = s.length();
		// 字典统计每个字符出现的次数
		for (int i = 0; i < length; ++i) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		Deque<Character> deque = new LinkedList<Character>();

		for (int i = 0; i < length; ++i) {

			char c = s.charAt(i);
			// 判断字符是否出现过，若出现过直接舍弃
			if (!deque.contains(c)) {
				// 如果要删除字符出现剩余次数大于0，则当前该字符可以删除
				while (!deque.isEmpty() && map.get(deque.peekLast()) > 0 && deque.peekLast() > c) {

					deque.removeLast();

				}

				deque.addLast(c);
			}

			map.put(c, map.get(c) - 1);
		}

		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.removeFirst());
		}

		return sb.toString();
	}

// ===================测试代码=====================
	public void test() {
		String s = "cbacdcbc";
		String result = removeDuplicateLetters(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

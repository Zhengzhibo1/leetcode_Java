import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

// ===================算法实现=====================
	// 方法1 双端队列作滑动窗口
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int lengthOfLongestSubstring(String s) {

		int maxLength = 0;
		char[] chars = s.toCharArray();
		Deque<Character> deque = new LinkedList<Character>();

		for (int i = 0; i < chars.length; ++i) {

			if (deque.contains(chars[i])) {
				maxLength = Math.max(maxLength, deque.size());

				while (deque.peekFirst() != chars[i]) {
					deque.pollFirst();
				}
				deque.offerLast(deque.pollFirst());
			} else {
				deque.offerLast(chars[i]);
			}
		}

		return Math.max(maxLength, deque.size());
	}

	// 方法2 动态规划
	// 时间复杂度O(n)
	// 空间复杂度O(1)，字符的 ASCII 码范围为 0 ~ 127
	public int lengthOfLongestSubstring2(String s) {
		int maxLength = 0;
		int temp = 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int index = 0; index < s.length(); ++index) {
			// 取最近相同字符的位置
			int p = map.getOrDefault(s.charAt(index), -1);
			// 更新位置
			map.put(s.charAt(index), index);
			temp = temp < index - p ? temp + 1 : index - p;
			maxLength = Math.max(maxLength, temp);
		}

		return maxLength;
	}

// ===================测试代码=====================
	public void test() {
		String s = "abcabcbb";
		int maxLength = lengthOfLongestSubstring(s);
		System.out.println(maxLength);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

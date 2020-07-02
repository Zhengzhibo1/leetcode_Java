import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

// ====================算法实现===================
	// 总结：
	// 时间复杂度：O(N)，其中 N 是字符串的长度。法1：遍历一次，法2：左右索引各遍历一次。
	// 空间复杂度：O(|Σ|)，其中 Σ 表示字符集（即字符串中可以出现的字符），|Σ| 表示字符集的大小。
	// 在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0, 128) 内的字符，即 |Σ| = 128。
	// 我们需要用到哈希集合来存储出现过的字符，而字符最多有 |Σ|个，因此空间复杂度为 O(|Σ|)。

	// 1、遍历过程中，用map存放位置，每次判断map中是否存在当前元素
	// 若存在当前元素，判断二者距离是否小于当前长度，
	// 若小于则表示与当前路径存在重复
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() <= 0) {
			return 0;
		}

		char[] strs = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int length = 0;
		int max = 0;
		for (int i = 0; i < strs.length; ++i) {
			if (map.containsKey(strs[i]) && (i - map.get(strs[i]) <= length)) {
				if (length > max) {
					max = length;
				}
				// 两元素间的距离即为当前剩余长度
				length = i - map.get(strs[i]);
				map.put(strs[i], i);
			} else {
				map.put(strs[i], i);
				length++;
			}
		}

		if (length > max) {
			max = length;
		}

		return max;
	}

	// 2、滑动窗口法
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		char[] strs = s.toCharArray();
		// 用HashSet模拟滑动窗口
		Set<Character> set = new HashSet<Character>();
		int max = 0;
		int rightIndex = -1;
		for (int i = 0; i < strs.length; ++i) {
			// 移除第一个元素
			if (i != 0) {
				set.remove(strs[i - 1]);
			}
			// 如果下一个字符没在set中出现
			while (rightIndex + 1 < strs.length && !set.contains(strs[rightIndex + 1])) {
				set.add(strs[rightIndex + 1]);
				rightIndex++;
			}

			max = max >= (rightIndex - i + 1) ? max : (rightIndex - i + 1);
		}

		return max;
	}

// ====================测试代码=================
	public void test1() {
		String str = "abcabcbb";
		// String str = "abba";
		int result = lengthOfLongestSubstring(str);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

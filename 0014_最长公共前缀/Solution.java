public class Solution {

// ====================算法实现=======================
	// 方法1 字符串横向比较
	// 时间复杂度O(MN)，M为字符串平均长度，N为字符串数量
	// 空间复杂度O(1)
	public String longestCommonPrefix(String[] strs) {

		// 边界条件判断
		if (strs == null || strs.length == 0) {
			return "";
		}

		int count = strs.length;
		// 默认最长前缀为第一个字符串
		String prefix = strs[0];
		// 字符串挨个比较
		for (int i = 1; i < count; ++i) {
			prefix = longestCommonPrefix(prefix, strs[i]);
			if (prefix.length() == 0) {
				break;
			}
		}
		return prefix;

	}

	private String longestCommonPrefix(String str1, String str2) {
		int length = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < length && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}

		return str1.substring(0, index);
	}

	// 方法2 字符串纵向比较
	// 时间复杂度O(MN)，M为字符串平均长度，N为字符串数量
	// 空间复杂度O(1)
	public String longestCommonPrefix2(String[] strs) {

		// 边界条件判断
		if (strs == null || strs.length == 0) {
			return "";
		}

		int count = strs.length;
		int length = strs[0].length();

		for (int i = 0; i < length; ++i) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; ++j) {
				// 如果到达某个字符串的末尾，或者字符不相等
				if (i == strs[j].length() || c != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}

		return strs[0];
	}

// ====================测试代码=======================
	public void test1() {
		String strs[] = { "flower", "flow", "flight" };
		String longestCommonPrefix = longestCommonPrefix2(strs);
		System.out.println("test1: " + longestCommonPrefix);
	}

	public void test2() {
		String strs[] = { "dog", "racecar", "car" };
		String longestCommonPrefix = longestCommonPrefix2(strs);
		System.out.println("test2: " + longestCommonPrefix);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

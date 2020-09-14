public class Solution {

// ====================算法实现====================
	// 1 暴力法
	// 时间复杂度O(n^3)，n为字符串长度，其中O(n^2)的时间枚举出所有子串，O(n)的时间进行判断
	// 空间复杂度O(n)，临时子串进行判断
	public int countSubstrings(String s) {

		int result = 0;
		if (s == null || s.length() == 0) {
			return result;
		}

		// i 表示字符串长度， j 表示起始位置
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 0; j + i <= s.length(); ++j) {
				String temp = s.substring(j, j + i);
				if (isString(temp)) {
					result++;
				}
			}
		}

		return result;
	}

	public boolean isString(String s) {
		if (s.length() == 1) {
			return true;
		}

		int index1 = 0, index2 = s.length() - 1;
		while (index1 < index2) {
			if (s.charAt(index1) != s.charAt(index2)) {
				return false;
			}
			index1++;
			index2--;
		}

		return true;
	}

	// 2 中心拓展法
	// 寻找回文中心，往外拓展
	// 长度为n的字符串能产生2n-1个回文中心，回文中心长度1或2
	// 时间复杂度O(n^2)
	// 空间复杂度O(1)
	public int countSubstrings2(String s) {
		int result = 0;
		if (s == null || s.length() == 0) {
			return result;
		}

		int length = s.length();
		for (int i = 0; i < length * 2 - 1; ++i) {
			int left = i / 2;
			int right = left + i % 2;
			while (left >= 0 && right < length && (s.charAt(left) == s.charAt(right))) {

				result++;
				left--;
				right++;
			}

		}

		return result;
	}

// ====================测试代码====================
	public void test() {
		String s = "abcb";
		int result = countSubstrings2(s);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

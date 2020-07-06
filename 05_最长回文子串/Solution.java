public class Solution {

// ====================算法实现===================
	// 总结：
	// 1、时间复杂度O(n^2),n是字符串长度。
	// 1、空间复杂度O(n^2),创建了N x N数组用来判断回文串
	// 2、时间复杂度O(n^2)
	// 2、空间复杂度O(1)

	// 1、动态规划
	public String longestPalindrome(String s) {
		String result = "";
		if (s == null || s.length() <= 0) {
			return result;
		}
		char[] strs = s.toCharArray();
		boolean[][] flag = new boolean[strs.length][strs.length];

		for (int l = 0; l < strs.length; ++l) { // 回文串长度为l
			for (int i = 0; i + l < strs.length; ++i) { // i为起始位置，j为中止位置
				int j = i + l;
				if (l == 0) {
					flag[i][j] = true;
				} else if (l == 1) {
					flag[i][j] = (strs[i] == strs[j]);
				} else {
					flag[i][j] = (strs[i] == strs[j] && flag[i + 1][j - 1]);
				}
				if (flag[i][j] && l + 1 > result.length()) {
					result = s.substring(i, j + 1);
				}
			}
		}

		return result;
	}

	// 2、中心扩展算法
	public String longestPalindrome2(String s) {
		String result = "";
		if (s == null || s.length() <= 0) {
			return result;
		}

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); ++i) {
			int len1 = expandAroundCenter(s, i, i); // 长度为1的回文中心
			int len2 = expandAroundCenter(s, i, i + 1); // 长度为2的回文中心
			int len = Math.max(len1, len2); // 以i为回文中心的回文串最长长度
			if (len > end - start + 1) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		result = s.substring(start, end + 1);
		return result;
	}

	public int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

// ===================测试代码==================
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "babad";
		String str1 = "cbbd";
		String str2 = "ab";
		String str3 = "abcba";
		String result = s.longestPalindrome2(str);
		System.out.println(result);

		String result1 = s.longestPalindrome2(str1);
		System.out.println(result1);

		String result2 = s.longestPalindrome2(str2);
		System.out.println(result2);

		String result3 = s.longestPalindrome2(str3);
		System.out.println(result3);
	}

}

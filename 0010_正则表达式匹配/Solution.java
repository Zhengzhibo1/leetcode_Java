public class Solution {

// ===================算法实现===================
	// 方法1 动态规划 dp[i][j]，表示s的前i个字符能否与p的前j个字符匹配，最后的返回结果为dp[m][n],m为s的长度，n为p的长度
	// 时间复杂度O(m * n)
	// 空间复杂度O(m * n)
	public boolean isMatch(String s, String p) {

		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];

		// 两个空串匹配
		dp[0][0] = true;
		for (int i = 0; i <= m; i++) {
			for (int j = 1; j <= n; ++j) {

				// 如果当前字符为*
				if (p.charAt(j - 1) == '*') {
					// 匹配0次
					dp[i][j] = dp[i][j - 2];
					if (match(s, i, p, j - 1)) {
						// 如果*前一字符匹配成功，则可以忽略s串的第i个字符
						dp[i][j] = dp[i][j] || dp[i - 1][j];
					}
				} else {
					if (match(s, i, p, j)) {
						// 如果当前对应字符匹配成功
						dp[i][j] = dp[i - 1][j - 1];
					}
				}
			}
		}

		return dp[m][n];
	}

	private boolean match(String s, int index1, String p, int index2) {

		// 空串匹配失败
		if (index1 == 0) {
			return false;
		}

		if (p.charAt(index2 - 1) == '.') {
			return true;
		}

		return s.charAt(index1 - 1) == p.charAt(index2 - 1);
	}

	// 方法2 递归
	// 时间复杂度O(m)，m为字符串s的长度
	// 空间复杂度O(m)，取决于递归深度
	public boolean isMatch2(String s, String p) {

		if (s == null || p == null) {
			return false;
		}

		return isMatchCore(s, 0, p, 0);
	}

	private boolean isMatchCore(String s, int index1, String p, int index2) {

		// 如果索引均到所对应字符串末尾，即匹配成功
		if (index1 == s.length() && index2 == p.length()) {
			return true;
		}

		// 如果pattern先到达末尾，即匹配失败
		if (index1 != s.length() && index2 == p.length()) {
			return false;
		}

		// 如果当前字符的下一个字符是*
		if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {

			// 判断当前字符是否匹配
			if ((index1 < s.length() && s.charAt(index1) == p.charAt(index2))
					|| (index1 < s.length() && p.charAt(index2) == '.')) {
				// 可以选择匹配0次或者多次
				return isMatchCore(s, index1, p, index2 + 2) || isMatchCore(s, index1 + 1, p, index2);
			} else {
				// 如果当前字符匹配失败，即匹配0次
				return isMatchCore(s, index1, p, index2 + 2);
			}
		} else {
			// 如果当前字符的下一个字符不为*
			if ((index1 < s.length() && s.charAt(index1) == p.charAt(index2))
					|| (index1 < s.length() && p.charAt(index2) == '.')) {
				return isMatchCore(s, index1 + 1, p, index2 + 1);
			}
		}

		return false;
	}

// ===================测试代码===================

	public void test(String testName, String str, String pattern, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (isMatch(str, pattern) == expected)
			System.out.printf("Passed.\n");
		else
			System.out.printf("FAILED.\n");
	}

	public static void main(String[] args) {
		Solution r = new Solution();
		r.test("test01", "", "", true);
		r.test("test02", "", ".*", true);
		r.test("test03", "", ".", false);
		r.test("test04", "", "c*", true);
		r.test("test05", "a", ".*", true);
		r.test("test06", "a", "a.", false);
		r.test("test07", "a", "", false);
		r.test("test08", "a", ".", true);
		r.test("test09", "a", "ab*", true);
		r.test("test10", "a", "ab*a", false);
		r.test("test11", "aa", "aa", true);
		r.test("test12", "aa", "a*", true);
		r.test("test13", "aa", ".*", true);
		r.test("test14", "aa", ".", false);
		r.test("test15", "ab", ".*", true);
		r.test("test16", "ab", ".*", true);
		r.test("test17", "aaa", "aa*", true);
		r.test("test18", "aaa", "aa.a", false);
		r.test("test19", "aaa", "a.a", true);
		r.test("test20", "aaa", ".a", false);
		r.test("test21", "aaa", "a*a", true);
		r.test("test22", "aaa", "ab*a", false);
		r.test("test23", "aaa", "ab*ac*a", true);
		r.test("test24", "aaa", "ab*a*c*a", true);
		r.test("test25", "aaa", ".*", true);
		r.test("test26", "aab", "c*a*b", true);
		r.test("test27", "aaca", "ab*a*c*a", true);
		r.test("test28", "aaba", "ab*a*c*a", false);
		r.test("test29", "bbbba", ".*a*a", true);
		r.test("test30", "bcbbabab", ".*a*a", false);

	}

}

public class Solution {

// ====================算法实现=========================
	// 方法 动态规划 + 滚动数组
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int numDecodings(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		int[] dp = new int[2];
		dp[0] = 1;
		dp[1] = 1;
		int length = s.length();
		for (int i = 1; i < length; ++i) {
			int temp = dp[1];
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
					temp = dp[0];
				} else {
					return 0;
				}
			} else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
				temp = dp[0] + dp[1];
			}

			dp[0] = dp[1];
			dp[1] = temp;
		}

		return dp[1];
	}

// ====================测试代码=========================
	public void test() {
		String s = "226";
		int count = numDecodings(s);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

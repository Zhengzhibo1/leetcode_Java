import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

// ====================算法实现===================
	// 1 动态规划
	// 时间复杂度O(n^2)，n为字符串长度。
	// 空见复杂度O(n)，创建数组存放临时结果。
	public boolean wordBreak(String s, List<String> wordDict) {

		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
			return false;
		}

		// 字典中，字符串的最大长度与最小长度
		int minSize = Integer.MAX_VALUE;
		int maxSize = 0;

		Set<String> set = new HashSet<String>();
		for (String str : wordDict) {
			set.add(str);
			minSize = Math.min(minSize, str.length());
			maxSize = Math.max(maxSize, str.length());
		}

		// 创建数组存放临时结果，空串为true
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		// 从长度1开始遍历
		for (int i = 1; i <= s.length(); ++i) {
			// 剪枝，减少不必要的循环，
			// 即分割点j后面的字符串的长度要在字典字符串最大长度与最小长度之间
			for (int j = Math.max(i - maxSize, 0); i - j >= minSize; ++j) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

// ====================测试代码===================
	public void test() {
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("apple");
		wordDict.add("pen");

		boolean result = wordBreak(s, wordDict);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

// ====================算法实现=====================
	// 1 动态规划 递归 回溯
	// 时间复杂度O(n^2)
	// 空间复杂度O(n^2)
	public List<List<String>> partition(String s) {

		List<List<String>> results = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return results;
		}

		// 预处理：动态规划，将回文串记录在二维数组中
		// dp[i][j]，i表示起始位置，j表示结束位置
		// 时间复杂度O(n^2)
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int right = 0; right < s.length(); ++right) {
			for (int left = 0; left <= right; ++left) {
				if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
					dp[left][right] = true;
				}
			}
		}

		// 回溯，采用双开队列
		Deque<String> deque = new ArrayDeque<String>();
		backtracking(s, 0, s.length(), dp, deque, results);

		return results;
	}

	// 递归 回溯 时间复杂度O(n^2)
	public void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> path,
			List<List<String>> results) {
		if (start == len) {
			results.add(new ArrayList<String>(path));
		}

		for (int i = start; i < len; ++i) {
			if (!dp[start][i]) {
				continue;
			}

			path.add(s.substring(start, i + 1));
			backtracking(s, i + 1, len, dp, path, results);
			path.removeLast();
		}
	}

// ====================测试代码=====================
	public void test() {
		String s = "aab";
		List<List<String>> results = partition(s);
		for (List<String> res : results) {
			for (String str : res) {
				System.out.print(str + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

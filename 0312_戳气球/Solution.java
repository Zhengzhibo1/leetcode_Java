import java.util.Arrays;

public class Solution {

// ====================算法实现=======================
	// 1 记忆化搜索
	// 时间复杂度O(n^3)
	// 空间复杂度O(n^2)
	public int[][] rec;
	public int[] val;

	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		val = new int[n + 2];
		for (int i = 1; i <= n; ++i) {
			val[i] = nums[i - 1];
		}
		val[0] = val[n + 1] = 1;
		rec = new int[n + 2][n + 2];
		for (int i = 0; i < n + 2; ++i) {
			Arrays.fill(rec[i], -1);
		}

		int result = solve(0, n + 1);
		return result;
	}

	public int solve(int left, int right) {
		if (left >= right - 1) {
			return 0;
		}
		if (rec[left][right] != -1) {
			return rec[left][right];
		}
		for (int i = left + 1; i < right; ++i) {
			int sum = val[left] * val[i] * val[right];
			sum += solve(left, i) + solve(i, right);
			rec[left][right] = Math.max(rec[left][right], sum);
		}

		return rec[left][right];
	}

	// 2 动态规划
	// 时间复杂度O(n^3)
	// 空间复杂度O(n^2)
	public int maxCoins2(int[] nums) {
		int n = nums.length;
		int[][] rec = new int[n + 2][n + 2];
		int[] val = new int[n + 2];
		val[0] = val[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
			val[i] = nums[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 2; j <= n + 1; j++) {
				for (int k = i + 1; k < j; k++) {
					int sum = val[i] * val[k] * val[j];
					sum += rec[i][k] + rec[k][j];
					rec[i][j] = Math.max(rec[i][j], sum);
				}
			}
		}

		return rec[0][n + 1];
	}

// ====================测试代码=======================
	public void test() {
		int[] nums = { 3, 1, 5, 8 };
		int result = maxCoins2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

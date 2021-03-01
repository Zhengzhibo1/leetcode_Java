public class Solution {

// ===================算法实现======================
	// 方法 动态规划，每一格的最大值等于 左边和上面格子的最大值 + 当前值
	// 时间复杂度O(m * n)，m和n分别为数组的行列数
	// 空间复杂度O(n)，n为数组的列数，滚动数组优化空间
	public int maxValue(int[][] grid) {

		// 边界条件判断
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;

		// 滚动数组
		int[] dp = new int[cols];
		dp[0] = grid[0][0];

		// 初始化第一行
		for (int i = 1; i < cols; ++i) {
			dp[i] = grid[0][i] + dp[i - 1];
		}

		for (int i = 1; i < rows; ++i) {
			// 初始化每一行的第一个值
			dp[0] += grid[i][0];
			for (int j = 1; j < cols; ++j) {
				dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
			}
		}

		return dp[cols - 1];
	}

// ===================测试代码======================
	public void test() {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int max = maxValue(grid);
		System.out.println(max);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

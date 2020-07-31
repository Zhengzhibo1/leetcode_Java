public class Solution {

// ====================算法实现=================
	// 1 动态规划
	// 时间复杂度O(mn)，m为数组行数，n为数组列数
	// 空间复杂度O(n)，创建n大小的数组，存放中间结果
	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		// 创建滚动数组优化空间
		int[] nums = new int[cols];

		nums[0] = grid[0][0];

		// 第一行元素，只能从左边元素走过来
		for (int i = 1; i < cols; ++i) {
			nums[i] = grid[0][i] + nums[i - 1];
		}

		for (int i = 1; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (j > 0) { // 该位置的和为上或左元素的最小值加上当前元素的值
					nums[j] = Math.min(nums[j - 1], nums[j]) + grid[i][j];
				} else { // 第一列元素，只能从上边元素走过来
					nums[j] += grid[i][j];
				}
			}
		}

		return nums[cols - 1];
	}

// ====================测试代码=================
	public void test() {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int result = minPathSum(grid);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

public class Solution {

// ====================算法实现=================
	// 1、递归实现
	// 缺点：当数据量较大时，存在大量重复步骤
	// leetcode测试时，测试样本较大情况下超时
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
			return 0;
		}
		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;
		int count = uniquePathsWithObstaclesCore(obstacleGrid, rows, cols, 0, 0);

		return count;
	}

	public int uniquePathsWithObstaclesCore(int[][] obstacleGrid, int rows, int cols, int row, int col) {
		int count = 0;
		// 越界
		if (row >= rows || col >= cols) {
			return 0;
		}
		// 碰见障碍物
		if (obstacleGrid[row][col] == 1) {
			return 0;
		}
		// 到达终点
		if (row == rows - 1 && col == cols - 1) {
			return 1;
		}
		// 正常情况下
		count = uniquePathsWithObstaclesCore(obstacleGrid, rows, cols, row + 1, col)
				+ uniquePathsWithObstaclesCore(obstacleGrid, rows, cols, row, col + 1);

		return count;
	}

	// 2、动态规划
	// 时间复杂度O(nm)，其中n为行数，m为列数
	// 空间复杂度O(m)，仅创建了m大小的数组存放结果，滚动数组优化
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
			return 0;
		}
		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;
		int[] f = new int[cols];

		f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (obstacleGrid[i][j] == 1) {
					f[j] = 0;
					continue;
				}
				if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] += f[j - 1];
				}
			}
		}

		return f[cols - 1];
	}

// ====================测试代码=================
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int result = s.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
		int[][] o = {
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1,
						0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0,
						0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1,
						0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
						0, 0 },
				{ 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1,
						0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1,
						0, 0 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0,
						0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0,
						0, 0 },
				{ 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0,
						1, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0,
						0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0,
						0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						1, 0 },
				{ 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						1, 0 },
				{ 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0,
						0, 0 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
						0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1,
						0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1,
						0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
						0, 0 } };
		long startTime = System.currentTimeMillis();
		System.out.println(s.uniquePathsWithObstacles(o));
		long endTime = System.currentTimeMillis();
		System.out.println("递归运行时间：" + (endTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		System.out.println(s.uniquePathsWithObstacles2(o));
		endTime = System.currentTimeMillis();
		System.out.println("动态规划运行时间：" + (endTime - startTime) + "ms");

	}

}

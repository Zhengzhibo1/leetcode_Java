public class Solution {

// ====================算法实现==================
	// 1 动态规划
	// 时间复杂度O(mn)，其中m为行数，n为列数
	// 空间复杂度O(n)，仅创建了n大小的数组存放结果，滚动数组优化
	public int uniquePaths(int m, int n) {

		int[] path = new int[n];
		path[0] = 1;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (j >= 1) {
					path[j] += path[j - 1];
				}
			}
		}

		return path[n - 1];
	}

// ====================测试代码==================
	public void test() {
		int rows = 3;
		int cols = 2;
		int result = uniquePaths(rows, cols);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

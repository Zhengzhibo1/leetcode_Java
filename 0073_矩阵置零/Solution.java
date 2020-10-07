public class Solution {

// ====================算法实现======================
	// 1 额外存储空间
	// 时间复杂度O(M x N)，其中M、N分别为数组的行数与列数
	// 空间复杂度O(M + N)
	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[] row = new int[rows];
		int[] col = new int[cols];

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (row[i] == 1 || col[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// 2 空间复杂度为1方法
	// 如果某个位置等于0，则把该位置对应行和列的第一个元素置0
	// 时间复杂度O(M x N)
	// 空间复杂度O(1)
	public void setZeroes2(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean isCol = false;

		for (int i = 0; i < rows; ++i) {

			// 判断第一列是否需要置0
			if (matrix[i][0] == 0) {
				isCol = true;
			}

			for (int j = 1; j < cols; ++j) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}

		}

		for (int i = 1; i < rows; ++i) {
			for (int j = 1; j < cols; ++j) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// 判断第一行是否需要置0
		// 能把(0,0)置0的只可能是第一行的数字，所以判断这个位置即可
		if (matrix[0][0] == 0) {
			for (int j = 1; j < cols; ++j) {
				matrix[0][j] = 0;
			}
		}

		// 判断第一列是否需要置0
		if (isCol == true) {
			for (int i = 0; i < rows; ++i) {
				matrix[i][0] = 0;
			}
		}

	}

// ====================测试代码======================
	public void test() {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes2(matrix);

		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

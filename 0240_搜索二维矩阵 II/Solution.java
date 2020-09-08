public class Solution {

// ====================算法实现====================
	// 1 从左下角开始查找，比该元素大指针右移，比该元素小指针上移
	// 时间复杂度O(m + n)，其中m和n分别为矩阵的行列数
	// 空间复杂度O(1)
	public boolean searchMatrix(int[][] matrix, int target) {

		// 边界条件判断
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int rowIndex = matrix.length - 1;
		int colIndex = 0;

		while (rowIndex >= 0 && colIndex < matrix[0].length) {
			if (matrix[rowIndex][colIndex] == target) {
				return true;
			} else if (matrix[rowIndex][colIndex] > target) {
				rowIndex--;
			} else {
				colIndex++;
			}
		}

		return false;
	}

	// 2 暴力法
	// 时间复杂度O(MN)
	// 空间复杂度O(1)
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (target == matrix[i][j]) {
					return true;
				}
			}
		}

		return false;
	}

// ===================测试代码=====================
	public void test() {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 5;

		boolean result = searchMatrix(matrix, target);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

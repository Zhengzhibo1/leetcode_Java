public class Solution {

// ===================算法实现====================
	// 从右上角开始判断
	// 时间复杂度O(m + n)，m和n分别为矩阵的行列数
	// 空间复杂度O(1)
	public boolean findNumberIn2DArray(int[][] matrix, int target) {

		// 边界条件判断
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		// 右上角出发
		int rows = matrix.length;
		int columns = matrix[0].length;
		int row = 0;
		int column = columns - 1;

		while (row < rows && column >= 0) {
			int num = matrix[row][column];
			if (num == target) {
				return true;
			} else if (num > target) {
				column--;
			} else {
				row++;
			}
		}

		return false;
	}

// ===================测试代码====================
	public void test() {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };

		int target = 5;
		boolean result = findNumberIn2DArray(matrix, target);
		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

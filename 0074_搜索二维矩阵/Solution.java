public class Solution {

// ====================算法实现==================
	// 方法 从右上角开始判断，（也可以从左下角开始判断）
	// 时间复杂度O(M * N)，其中 M，N 分别为数组的行和列
	// 空间复杂度O(1)
	public boolean searchMatrix(int[][] matrix, int target) {

		// 边界条件判断
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		// 从右上角开始判断
		for (int i = 0; i < rows; ++i) {
			for (int j = cols - 1; j >= 0; --j) {
				if (target == matrix[i][j]) {
					return true;
				}

				// 直接进入下一行
				if (target > matrix[i][j]) {
					break;
				}

				// 如果该行没找到，就是false
				if (j == 0) {
					return false;
				}
			}
		}

		return false;
	}

// ====================测试代码==================
	public void test1() {
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int target = 3;
		boolean result = searchMatrix(matrix, target);
		System.out.println("test1：" + result);
	}

	public void test2() {
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int target = 13;
		boolean result = searchMatrix(matrix, target);
		System.out.println("test2：" + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

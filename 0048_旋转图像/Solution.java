import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现================
	// 1 创建一个List储存原数组，然后再构建旋转后的数组
	// 时间复杂度O(n^2)，其中n为数组的长度
	// 空间复杂度O(n^2)，需要一个与原数组一样大的空间储存原数组
	public void rotate(int[][] matrix) {

		if (matrix == null) {
			return;
		}

		int length = matrix.length;
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < length; ++i) {
			list.add(new int[length]);
			for (int j = 0; j < length; ++j) {
				list.get(i)[j] = matrix[i][j];
			}
		}

		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length; ++j) {
				matrix[i][j] = list.get(length - 1 - j)[i];
			}
		}
	}

	// 2 先转置矩阵，再翻转每一行
	// 时间复杂度O(n^2)
	// 空间复杂度O(1)
	// 1 2 3   1 4 7   7 4 1
	// 4 5 6   2 5 8   8 5 2
	// 7 8 9   3 6 9   9 6 3
	public void rotate2(int[][] matrix) {
		int length = matrix.length;

		// 转置矩阵
		for (int i = 0; i < length; ++i) {
			for (int j = i; j < length; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// 翻转每一行
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length / 2; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][length - 1 - j];
				matrix[i][length - 1 - j] = temp;
			}
		}

	}

	// 3 单次循环旋转4个矩形
	// 时间复杂度O(n^2)
	// 空间复杂度O(1)
	public void rotate3(int[][] matrix) {

		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; ++i) {
			for (int j = 0; j < n / 2; ++j) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}

// ====================测试代码================
	public void test() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate3(matrix);
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

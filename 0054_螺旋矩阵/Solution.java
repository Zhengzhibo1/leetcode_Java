import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现==================
	// 方法 模拟
	// 时间复杂度O(MN)，M 和 N 分别为矩阵的行数与列数
	// 空间复杂度O(1)
	/*
	 * 模拟矩阵外圈到内圈的过程
	 */
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
		int index = 0;
		// 总数量
		int count = (bottom + 1) * (right + 1);
		while (index < count) {

			// 从左到右
			for (int i = left; i <= right; ++i) {
				result.add(matrix[top][i]);
				index++;
			}
			if (index == count) {
				break;
			}
			top++;
			// 从上到下
			for (int i = top; i <= bottom; ++i) {
				result.add(matrix[i][right]);
				index++;
			}
			if (index == count) {
				break;
			}
			right--;
			// 从右到左
			for (int i = right; i >= left; --i) {
				result.add(matrix[bottom][i]);
				index++;
			}
			if (index == count) {
				break;
			}
			bottom--;
			// 从下到上
			for (int i = bottom; i >= top; --i) {
				result.add(matrix[i][left]);
				index++;
			}
			if (index == count) {
				break;
			}
			left++;
		}

		return result;
	}

// ===================测试代码==================
	public void test1() {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> result = spiralOrder(matrix);
		System.out.println("test1:");
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	public void test2() {
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		List<Integer> result = spiralOrder(matrix);
		System.out.println("test2:");
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();
	}

}

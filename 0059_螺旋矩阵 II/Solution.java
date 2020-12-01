public class Solution {

// ===================算法实现==================
	// 方法 模拟
	// 时间复杂度O(n*n)，共有n*n个数字需要填入
	// 空间复杂度O(1)
	public int[][] generateMatrix(int n) {

		int matrix[][] = new int[n][n];

		int left = 0, right = n - 1, bottom = n - 1, top = 0;
		int num = 1;
		while (num <= n * n) {
			// 从左到右填充
			for (int i = left; i <= right; ++i) {
				matrix[top][i] = num;
				num++;
			}
			top++;
			// 从上到下
			for (int i = top; i <= bottom; ++i) {
				matrix[i][right] = num;
				num++;
			}
			right--;
			// 从右往左
			for (int i = right; i >= left; --i) {
				matrix[bottom][i] = num;
				num++;
			}
			bottom--;
			// 从下到上
			for (int i = bottom; i >= top; --i) {
				matrix[i][left] = num;
				num++;
			}
			left++;
		}

		return matrix;
	}

// ===================测试代码==================
	public void test() {
		int n = 3;
		int result[][] = generateMatrix(n);
		for (int i = 0; i < result.length; ++i) {
			for (int j = 0; j < result[0].length; ++j) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

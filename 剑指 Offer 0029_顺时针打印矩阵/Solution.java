public class Solution {

// ===================算法实现====================
	// 方法 模拟
	// 时间复杂度O(MN)，M和N分别位matrix的行列数，每个数字遍历一次
	// 空间复杂度O(1)
	public int[] spiralOrder(int[][] matrix) {

		// 边界条件判断
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}

		// 结果数组
		int[] nums = new int[matrix.length * matrix[0].length];
		int index = 0;
		int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

		// 模拟顺时针数组输出
		while (true) {

			// 左往右
			for (int i = left; i <= right; ++i) {
				nums[index++] = matrix[top][i];
			}
			top++;
			if (top > bottom) {
				break;
			}

			// 上往下
			for (int i = top; i <= bottom; ++i) {
				nums[index++] = matrix[i][right];
			}
			right--;
			if (right < left) {
				break;
			}

			// 右往左
			for (int i = right; i >= left; --i) {
				nums[index++] = matrix[bottom][i];
			}
			bottom--;
			if (bottom < top) {
				break;
			}

			// 下往上
			for (int i = bottom; i >= top; --i) {
				nums[index++] = matrix[i][left];
			}
			left++;
			if (left > right) {
				break;
			}
		}

		return nums;
	}

// ===================测试代码====================
	public void test() {
		int[][] matrix = { { 2, 5, 8 }, { 4, 0, -1 } };
		int[] nums = spiralOrder(matrix);
		for (int i : nums) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

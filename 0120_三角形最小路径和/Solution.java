import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现====================
	// 方法1 动态规划，注意边界，第一个数字与最后一个数字的赋值
	// 时间复杂度O(n^2)，其中n为三角形的行数
	// 空间复杂度O(n^2)
	public int minimumTotal(List<List<Integer>> triangle) {

		int rows = triangle.size();
		int dp[][] = new int[rows][rows];
		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < rows; ++i) {
			// 每一行的第一个数
			dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
			for (int j = 1; j < i; ++j) {
				// 中间数字的状态转移方程
				dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);

			}
			// 每一行的最后一个数
			dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
		}

		int minTotal = dp[rows - 1][0];
		for (int i = 1; i < rows; ++i) {
			minTotal = Math.min(minTotal, dp[rows - 1][i]);
		}

		return minTotal;
	}

	// 方法2 动态规划 + 滚动数组。每个数值和仅与上一个数字以及上一个数字的前一个数字有关，所以使用滚动数组，需要从后往前计算
	// 时间复杂度O(n^2)，其中n为三角形的行数
	// 空间复杂度O(n)
	public int minimumTotal2(List<List<Integer>> triangle) {

		int rows = triangle.size();
		int dp[] = new int[rows];
		dp[0] = triangle.get(0).get(0);

		for (int i = 1; i < rows; ++i) {

			// 每一行的最后一个数
			dp[i] = dp[i - 1] + triangle.get(i).get(i);

			for (int j = i - 1; j > 0; --j) {
				// 中间数字的状态转移方程
				dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);

			}
			// 每一行的第一个数
			dp[0] = dp[0] + triangle.get(i).get(0);
		}

		int minTotal = dp[0];
		for (int i = 1; i < rows; ++i) {
			minTotal = Math.min(minTotal, dp[i]);
		}

		return minTotal;
	}

// ====================测试代码====================
	public void test() {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(2);
		triangle.add(temp);
		temp = new ArrayList<Integer>();
		temp.add(3);
		temp.add(4);
		triangle.add(temp);
		temp = new ArrayList<Integer>();
		temp.add(6);
		temp.add(5);
		temp.add(7);
		triangle.add(temp);
		temp = new ArrayList<Integer>();
		temp.add(4);
		temp.add(1);
		temp.add(8);
		temp.add(3);
		triangle.add(temp);

		int result = minimumTotal(triangle);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

public class Solution {

// ====================算法实现================

	// 1 动态规划
	// 时间复杂度 O(n)，循环执行 n 次，故渐进时间复杂度为 O(n)
	// 空间复杂度O(1)
	// 此题目本质就是斐波拉契数列
	public int climbStairs(int n) {

		if (n == 1) {
			return 1;
		}

		int num1 = 1;
		int num2 = 1;
		int temp = 0;
		for (int i = 2; i <= n; ++i) {
			temp = num1 + num2;
			num1 = num2;
			num2 = temp;
		}

		return temp;
	}

// ====================测试代码================
	public void test() {
		int result = climbStairs(10);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

public class Solution {

// ===================算法实现====================
	// 方法 动态规划 + 空间优化
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int fib(int n) {

		// 边界条件判断
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int num1 = 0;
		int num2 = 1;
		int cur = 0;
		for (int i = 2; i <= n; ++i) {
			cur = (num1 + num2) % 1000000007;

			num1 = num2;
			num2 = cur;
		}

		return cur;
	}

// ===================测试代码====================
	public void test() {
		int n = 5;
		int result = fib(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

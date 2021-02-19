public class Solution {

// ===================算法实现=======================
	// 方法 动态规划，斐波拉契数列
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int numWays(int n) {

		// 边界条件判断
		if (n == 0 || n == 1) {
			return 1;
		}

		int a = 1;
		int b = 1;
		int cur = 0;
		for (int i = 2; i <= n; ++i) {
			cur = (a + b) % 1000000007;
			a = b;
			b = cur;
		}

		return cur;
	}

// ===================测试代码=======================
	public void test() {
		int n = 5;
		int result = numWays(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

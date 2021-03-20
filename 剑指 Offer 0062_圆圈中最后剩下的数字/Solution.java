public class Solution {

// ===================算法实现========================
	// 方法 动态规划 f(n) = (f(n - 1) + m) % n;
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int lastRemaining(int n, int m) {

		int result = 0;
		for (int i = 2; i <= n; ++i) {
			result = (result + m) % i;
		}

		return result;
	}

// ===================测试代码========================
	public void test() {
		int n = 10;
		int m = 17;
		int result = lastRemaining(n, m);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

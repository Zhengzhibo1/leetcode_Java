public class Solution {

// ===================算法实现=======================
	// 方法1 递归
	// 时间复杂度O(log N)
	// 空间复杂度O(log N)，递归深度
	public double myPow(double x, int n) {

		long N = n;
		return n >= 0 ? myPowCore(x, N) : 1.0 / myPowCore(x, -N);

	}

	private double myPowCore(double x, long n) {
		// 边界条件判断
		if (n == 0) {
			return 1.0;
		}

		double y = myPowCore(x, n / 2);
		return n % 2 == 0 ? y * y : y * y * x;
	}

	// 方法2 迭代
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public double myPow2(double x, int n) {
		long N = n;
		return n >= 0 ? myPowCore2(x, N) : 1.0 / myPowCore2(x, -N);
	}

	private double myPowCore2(double x, long n) {
		double result = 1.0;
		double temp = x;
		while (n > 0) {
			if (n % 2 == 1) {
				// 奇数
				result *= temp;
			}

			temp *= temp;
			n = n / 2;
		}
		return result;
	}

// ===================测试代码=======================
	public void test() {
		double x = 2.0;
		int n = 10;
		double result = myPow(x, n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

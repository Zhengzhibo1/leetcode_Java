public class Solution {

// ===================算法实现======================
	// 方法 二分法快速幂值
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public double myPow(double x, int n) {

		// 边界条件判断
		if (x == 0) {
			return 0;
		}

		// 指数转换为正
		long b = n;
		if (b < 0) {
			x = 1 / x;
			b = -b;
		}
		double result = 1.0;
		while (b > 0) {

			if ((b & 1) == 1) {
				// 如果为奇数次方
				result *= x;
			}

			// 二分幂值
			x *= x;
			b /= 2;
		}

		return result;
	}

// ===================测试代码======================
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

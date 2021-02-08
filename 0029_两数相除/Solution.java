public class Solution {

// ===================算法实现=====================
	// 方法 递归 + 加法
	// 时间复杂度O(log N)
	// 空间复杂度O(log N)
	public int divide(int dividend, int divisor) {

		// 边界条件判断
		if (dividend == 0) {
			return 0;
		}

		if (divisor == 1) {
			return dividend;
		}

		if (divisor == -1) {
			if (dividend > Integer.MIN_VALUE) {
				return -dividend;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		long a = dividend;
		long b = divisor;
		// 正负标志位
		int sign = 1;
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
			sign = -1;
		}

		if (a < 0) {
			a = -a;
		}

		if (b < 0) {
			b = -b;
		}

		int res = div(a, b);

		return res * sign;
	}

	private int div(long a, long b) {

		if (a < b) {
			return 0;
		}

		long count = 1;
		long tb = b;
		while ((tb + tb) <= a) {
			count = count + count;
			tb = tb + tb;
		}

		return (int) (count + div(a - tb, b));
	}

// ===================测试代码=====================
	public void test() {
		int dividend = 2147483647;
		int divisor = 2;
		int result = divide(dividend, divisor);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

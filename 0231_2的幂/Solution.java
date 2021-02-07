public class Solution {

// ===================算法实现====================
	// 方法 %2
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public boolean isPowerOfTwo(int n) {

		if (n == 0) {
			return false;
		}

		int temp = n;
		while (temp % 2 == 0) {

			temp = temp / 2;

		}

		return temp == 1;
	}

	// 方法2 位运算，2的幂的二进制只有一个1
	public boolean isPowerOfTwo2(int n) {

		if (n == 0) {
			return false;
		}

		long temp = (long) n;
		return (temp & (-temp)) == temp;

	}

	// 方法3 位运算，二进制最右边1置0
	public boolean isPowerOfTwo3(int n) {

		if (n == 0) {
			return false;
		}

		long temp = (long) n;
		return (temp & (temp - 1)) == 0;
	}

// ===================测试代码====================
	public void test() {
		int n = 16;
		boolean result = isPowerOfTwo3(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

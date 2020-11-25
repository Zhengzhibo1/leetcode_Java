public class Solution {

// ===================算法实现=====================
	// 方法：循环迭代
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public boolean isPowerOfThree(int n) {
		// 边界条件判断
		if (n < 1) {
			return false;
		}

		boolean flag = false;

		while (n % 3 == 0) {
			n = n / 3;
		}
		if (n == 1) {
			flag = true;
		}

		return flag;
	}

// ===================测试代码=====================
	public void test() {
		int n = 27;
		boolean result = isPowerOfThree(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

public class Solution {

// ===================算法实现=====================
	// 方法 尽可能多的3
	// 时间复杂度O(1)
	// 空间复杂度O(1)
	public int cuttingRope(int n) {

		if (n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}

		int result = 1;
		int count3 = n / 3;
		n = n % 3;
		if (n == 1) {
			result *= 4;
			result *= Math.pow(3, count3 - 1);
			return result;
		}

		int count2 = n / 2;
		result *= Math.pow(3, count3);
		result *= Math.pow(2, count2);

		return result;
	}

// ===================测试代码=====================
	public void test() {
		int n = 10;
		int result = cuttingRope(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

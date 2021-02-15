public class Solution {

// ===================算法实现=====================
	// 方法 计算因子5
	// 时间复杂度O(log N)
	// 空间复杂度O(1)
	public int trailingZeroes(int n) {

		int zeroCount = 0;
		while (n > 0) {
			n /= 5;
			zeroCount += n;
		}

		return zeroCount;
	}

// ===================测试代码=====================
	public void test() {
		int n = 5;
		int zeroCount = trailingZeroes(n);
		System.out.println(zeroCount);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

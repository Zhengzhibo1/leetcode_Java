public class Solution {

// ===================算法实现=====================
	// 方法 位移+寻找公共前缀+后面补零
	// 时间复杂度O()
	// 空间复杂度O(1)
	public int rangeBitwiseAnd(int m, int n) {

		int count = 0;

		while (m < n) {
			m = m >> 1;
			n = n >> 1;
			count++;
		}

		return n << count;
	}

// ===================测试代码=====================
	public void test() {
		int m = 1092;
		int n = 3048;
		int result = rangeBitwiseAnd(m, n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

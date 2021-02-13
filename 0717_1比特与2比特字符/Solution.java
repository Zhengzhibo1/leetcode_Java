public class Solution {

// ===================算法实现======================

	// 方法 线性扫描
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public boolean isOneBitCharacter(int[] bits) {

		// 边界条件判断
		if (bits == null || bits.length == 0) {
			return false;
		}

		for (int i = 0; i < bits.length; ++i) {

			if (i == bits.length - 1) {
				return true;
			}

			if (bits[i] == 1) {
				i++;
			}

		}
		return false;
	}

// ====================测试代码=====================
	public void test() {
		int[] bits = { 1, 1, 1, 0 };
		boolean result = isOneBitCharacter(bits);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

public class Solution {

// ===================算法实现====================
	// 方法 分组异或
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] singleNumbers(int[] nums) {

		// 找到两个出现一次数字的不同位
		int n = 0;
		for (int i : nums) {
			n ^= i;
		}
		int m = 1;
		while ((n & m) == 0) {
			m <<= 1;
		}

		int x = 0, y = 0;
		for (int i : nums) {
			if ((i & m) != 0) {
				x ^= i;
			} else {
				y ^= i;
			}
		}

		return new int[] { x, y };
	}

// ===================测试代码====================
	public void test() {
		int[] nums = { 4, 1, 4, 6 };
		int[] result = singleNumbers(nums);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

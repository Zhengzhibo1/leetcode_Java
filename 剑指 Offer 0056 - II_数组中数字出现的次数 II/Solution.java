public class Solution {

// ===================算法实现====================
	// 方法1 遍历统计
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int singleNumber(int[] nums) {

		int[] counts = new int[32];
		for (int num : nums) {
			for (int i = 0; i < 32; ++i) {
				counts[i] += num & 1;
				num >>>= 1;
			}
		}

		int res = 0;
		for (int i = 0; i < 32; ++i) {
			res <<= 1;
			res |= counts[31 - i] % 3;
		}

		return res;
	}

	// 方法2 有限状态机 00 01 10
	public int singleNumber2(int[] nums) {

		int ones = 0, twos = 0;
		for (int num : nums) {

			ones = ones ^ num & ~twos;
			twos = twos ^ num & ~ones;
		}

		return ones;
	}

// ===================测试代码====================
	public void test() {
		int[] nums = { 3, 4, 3, 3 };
		int result = singleNumber2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

public class Solution {

// ====================算法实现==================
	// 方法 贪心
	// https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
	// 时间复杂度O(m + logN)，其中m为数组的长度，n为给定正整数，因为上下为n，对x的更新不会超过logN次
	// 空间复杂度O(1)
	public int minPatches(int[] nums, int n) {

		// 补充数字数量
		int patches = 0;
		long x = 1;
		int length = nums.length;
		int index = 0;

		// 覆盖区间为[1, x - 1]
		while (x <= n) {
			if (index < length && nums[index] <= x) {
				x += nums[index];
				index++;
			} else {
				x *= 2;
				patches++;
			}
		}
		return patches;
	}

// ====================测试代码==================
	public void test() {
		int nums[] = { 1, 5, 10 };
		int n = 20;
		int count = minPatches(nums, n);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

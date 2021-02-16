public class Solution {

// ===================算法实现=====================
	// 方法 动态规划
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int nthUglyNumber(int n) {

		int[] nums = new int[n];
		nums[0] = 1;

		int ugly, index2 = 0, index3 = 0, index5 = 0;
		for (int i = 1; i < n; ++i) {
			ugly = Math.min(Math.min(nums[index2] * 2, nums[index3] * 3), nums[index5] * 5);
			nums[i] = ugly;

			if (ugly == nums[index2] * 2) {
				index2++;
			}

			if (ugly == nums[index3] * 3) {
				index3++;
			}

			if (ugly == nums[index5] * 5) {
				index5++;
			}
		}

		return nums[n - 1];
	}

// ===================测试代码=====================
	public void test() {
		int n = 10;
		int result = nthUglyNumber(n);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

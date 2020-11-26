public class Solution {

// ===================算法实现=====================
	// 方法：动态规划
	// 时间复杂度O(n * target)，其中n为数组长度，target为数组和的一半
	// 空间复杂度O(target)，经滚动数组优化的情况下
	/*
	 * 首先边界条件的考虑： 1、如果数组的数量小于2，则无法分割 2、如果数组的和为奇数，则无法分割 3、如果数组的最大数字大于数组和的一半，则无法分割
	 * 动态规划： 创建初始化数组dp[i][target + 1]，其中i为数组长度，target为数组和的一半
	 * dp[i][j]，表示从数组0-i的下标中，任意选取数字，和是否能达到j 递归公式： 1、如果当前数字小于目标和j，dp[i][j] =
	 * dp[i-1][j]|dp[i-1][j-nums[i]]， 表示当前数字可以不被选中或者被选中 2、如果当前数字大于目标和j，dp[i][j] =
	 * dp[i-1][j]， 表示当前数字不能被选中
	 */
	public boolean canPartition(int[] nums) {
		// 边界条件判断
		// 如果数组为空，或者长度小于2，则返回false
		if (nums == null || nums.length < 2) {
			return false;
		}
		int sum = 0, maxNum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxNum = Math.max(maxNum, nums[i]);
		}
		// 如果数组的和为奇数，或者数组的最大值大于数组和的一半，返回false
		if ((sum & 1) != 0 || maxNum > (sum >> 1)) {
			return false;
		}

		// 数组长度
		int length = nums.length;
		// 目标值
		int target = sum >> 1;

		/*
		 * dp[0][nums[0]] = true; dp[i][0] = true;
		 */
		// 创建dp数组，默认值为false，初始化
		boolean dp[][] = new boolean[nums.length][(sum >> 1) + 1];
		dp[0][nums[0]] = true;
		for (int i = 0; i < nums.length; ++i) {
			dp[i][0] = true;
		}
		// 递归公式
		for (int i = 1; i < length; ++i) {
			int num = nums[i];
			for (int j = 1; j <= target; ++j) {
				if (j >= num) {
					// 如果j 大于等于当前数字，则当前数字可以选或不选
					dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
				} else {
					// j小于当前数字
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[length - 1][target];
	}

	/*
	 * 优化空间复杂度 递归过程中，数组的结果仅与上一行的结果有关， 故可以采用滚动数组优化， 但需要注意的是，下一行要从大向小计算，
	 * 否则，更新dp[j]时，dp[j - nums[i]就已经被更新了， 不再是上一行的结果了
	 */
	public boolean canPartition2(int[] nums) {
		// 边界条件判断
		// 如果数组为空，或者长度小于2，则返回false
		if (nums == null || nums.length < 2) {
			return false;
		}
		int sum = 0, maxNum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxNum = Math.max(maxNum, nums[i]);
		}
		// 如果数组的和为奇数，或者数组的最大值大于数组和的一半，返回false
		if ((sum & 1) != 0 || maxNum > (sum >> 1)) {
			return false;
		}

		// 数组长度
		int length = nums.length;
		// 目标值
		int target = sum >> 1;

		// 创建dp数组，默认值为false，初始化,dp[0] = true;
		boolean dp[] = new boolean[(sum >> 1) + 1];
		dp[0] = true;

		// 递归公式
		for (int i = 0; i < length; ++i) {
			int num = nums[i];
			for (int j = target; j >= num; --j) {

				// 如果j 大于等于当前数字，则当前数字可以选或不选
				dp[j] = dp[j] | dp[j - num];
			}
		}
		return dp[target];
	}

// ===================测试代码=====================
	public void test1() {
		int nums[] = { 1, 5, 11, 5 };
		boolean result = canPartition2(nums);
		System.out.println("测试1的结果为：" + result);
	}

	public void test2() {
		int nums[] = { 1, 2, 3, 5 };
		boolean result = canPartition2(nums);
		System.out.println("测试2的结果为：" + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

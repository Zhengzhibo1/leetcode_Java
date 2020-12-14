import java.util.Arrays;

public class Solution {

// ====================算法实现========================
	// 方法 排序 + 枚举 + 双指针
	// 时间复杂度O( N^2)，其中 N 为数组长度
	// 空间复杂度O( log N)
	/*
	 * 首先将输入数组排序，排序的时候时间复杂度O(N log N)，空间复杂度O(log N),
	 * 但如果不允许修改原数组的话，则需要数组的副本，即空间复杂度为O(N)，排序完成后， 按顺序枚举每个数字，然后再其右边剩余数字中，采用双指针法进行计算。
	 */
	public int threeSumClosest(int[] nums, int target) {

		// 对数组排序
		Arrays.sort(nums);
		int best = 10000;

		for (int i = 0; i < nums.length; ++i) {
			// 剪枝，保证当前枚举数字与上一轮不一样
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// 计算枚举后剩余的目标值
			int t = target - nums[i];
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				// 根据差值的绝对值来更新答案
				int sum = nums[left] + nums[right] + nums[i];
				if (Math.abs(sum - target) < Math.abs(best - target)) {
					best = sum;
				}

				// 如果两数相加比目标值大，则右指针左移
				if (nums[left] + nums[right] > t) {
					right--;
				} else if (nums[left] + nums[right] < t) {
					left++;
				} else {
					// 如果相等，即为最优结果
					return target;
				}
			}
		}
		return best;
	}

// ====================测试代码========================
	public void test() {
		int nums[] = { -1, 2, 1, -4 };
		int target = 1;
		int result = threeSumClosest(nums, target);

		System.out.println(result);
	}

	public void test2() {
		int nums[] = { -3, -2, -5, 3, -4 };
		int target = 1;
		int result = threeSumClosest(nums, target);

		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
		s.test2();
	}

}

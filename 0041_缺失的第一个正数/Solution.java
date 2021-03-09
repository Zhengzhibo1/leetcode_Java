public class Solution {

// ====================算法实现======================
	// 方法1 哈希表，利用当前数组模拟哈希表
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public int firstMissingPositive(int[] nums) {

		int n = nums.length;

		// 第一次遍历将所有<= 0的数字设为n+1
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] <= 0) {
				nums[i] = n + 1;
			}
		}

		// 第二次遍历将所有<=n的数字 标记为负数
		for (int i = 0; i < nums.length; ++i) {

			int num = Math.abs(nums[i]);
			if (num <= n) {
				nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}

		// 第三次遍历找出结果
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}

		return n + 1;
	}

	// 方法2 置换，将符合条件的数字置换到本该存在的位置
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public int firstMissingPositive2(int[] nums) {

		int n = nums.length;

		// 第一次遍历，置换数字
		for (int i = 0; i < nums.length; ++i) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}

		// 第二次遍历，找出结果
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return n + 1;
	}

// ====================测试代码======================
	public void test() {
		int[] nums = { 1, 2, 0 };
		int result = firstMissingPositive2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

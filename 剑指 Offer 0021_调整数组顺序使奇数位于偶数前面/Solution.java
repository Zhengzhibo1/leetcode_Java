public class Solution {

// ===================算法实现======================、
	// 方法1 快慢指针
	// 时间复杂度O(n)，n为数组的长度
	// 空间复杂度O(1)
	public int[] exchange(int[] nums) {

		// 奇数下标索引
		int index = 0;
		for (int i = 0; i < nums.length; ++i) {

			if (nums[i] % 2 != 0) {
				// 如果该数字是奇数
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;

				index++;
			}
		}

		return nums;
	}

	// 方法2 首尾指针法
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int[] exchange2(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {

			// 遇到偶数停止
			while (left < right && ((nums[left] & 1) != 0)) {
				left++;
			}

			// 遇到奇数停止
			while (left < right && (nums[right] & 1) != 1) {
				right--;
			}

			// 交换两数字
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}

		return nums;
	}

// ===================测试代码======================
	public void test() {

		int[] nums = { 1, 2, 3, 4 };
		int[] result = exchange2(nums);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

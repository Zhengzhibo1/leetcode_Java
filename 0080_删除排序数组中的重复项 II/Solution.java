public class Solution {

// ====================算法实现=====================
	// 方法 一次遍历+双指针
	// 时间复杂度O(n)，n为数组长度
	// 空间复杂度O(1)
	public int removeDuplicates(int[] nums) {

		int count = 0;
		int temp = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] != temp) {
				temp = nums[i];
				count = 1;
				continue;
			}
			while (nums[i] == temp && count == 2) {
				nums[i] = Integer.MIN_VALUE;
			}
			if (nums[i] == temp) {
				count++;
			}
		}

		int index = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != Integer.MIN_VALUE) {
				nums[index] = nums[i];
				index++;
			}
		}

		return index;
	}

	// 改进
	public int removeDuplicates2(int[] nums) {
		int index = 1;
		int count = 1;

		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[i - 1]) {
				count++;

			} else {
				count = 1;
			}

			if (count <= 2) {
				nums[index++] = nums[i];
			}
		}

		return index;
	}

// ====================测试代码=====================
	public void test() {
		int nums[] = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		int result = removeDuplicates2(nums);
		System.out.println(result);

		for (int i = 0; i < result; ++i) {
			System.out.print(nums[i] + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

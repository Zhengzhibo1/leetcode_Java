public class Solution {

// ====================算法实现================
	// 1 从后往前移动数组
	// 时间复杂度O(n)，其中n为数组长度，每次遇到重复数字时都需要后移
	// 故for循环嵌套
	// 空间复杂度O(1)
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int newLen = 0;
		for (int i = len - 1; i > 0; --i) {
			// 如果有个数和前面数不等，说明这是重复数字中的第一个
			// 新长度+1
			if (nums[i] != nums[i - 1]) {
				newLen++;
			} else { // 如果这个数和前面数相等，说明是重复数字，往后移
						// 题目表明，新长度数组后面的数字不用管，所以可以将数字往后移
				for (int j = 0; j < newLen; ++j) {
					int temp = nums[i + j];
					nums[i + j] = nums[i + j + 1];
					nums[i + j + 1] = temp;
				}

			}
		}
		// 因为第一个数字没算进去，所以要+1
		return newLen + 1;
	}
	
	// 2 双指针
	public int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0;
		for (int j = 1; j < nums.length; ++j) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}

		// 因为i从0开始，所以要+1
		return i + 1;
	}

// ====================测试代码================
	public void test1() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int result = removeDuplicates2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

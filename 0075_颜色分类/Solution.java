public class Solution {

// ====================算法实现==================
	// 1 计数 重写数组
	// 时间复杂度O(n)，n为数组长度
	// 空间复杂度O(1)，仅修改原数组
	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}

		int count0 = 0;
		int count1 = 0;

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0) {
				count0++;
			} else if (nums[i] == 1) {
				count1++;
			}
		}

		for (int i = 0; i < count0; ++i) {
			nums[i] = 0;
		}

		for (int i = count0; i < count0 + count1; ++i) {
			nums[i] = 1;
		}

		for (int i = count0 + count1; i < nums.length; ++i) {
			nums[i] = 2;
		}
	}

	// 一次遍历 三指针
  // 时间复杂度O(n)
	// 空间复杂度O(1)
	public void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		// p0为元素0的最右边界
		// p2为元素2的最左边界
		int p0 = 0, cur = 0;
		int p2 = nums.length - 1;

		int temp = 0;
		while (cur <= p2) {
			if (nums[cur] == 0) {
				temp = nums[cur];
				nums[cur] = nums[p0];
				nums[p0] = temp;
				p0++;
				cur++;
			} else if (nums[cur] == 2) {
				temp = nums[cur];
				nums[cur] = nums[p2];
				nums[p2] = temp;
				p2--;
			} else {
				cur++;
			}
		}
	}

// ====================测试代码==================
	public void test1() {
		int[] nums = { 1, 2, 0 };
		sortColors2(nums);
		for (int i : nums) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

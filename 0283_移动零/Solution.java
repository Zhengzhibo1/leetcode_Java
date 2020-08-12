import java.util.ArrayList;
import java.util.List;

public class Solution {

// =====================算法实现===================
	// 1 利用额外空间
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public void moveZeroes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}
		int numZeroes = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0) {
				numZeroes++;
			}
		}

		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				temp.add(nums[i]);
			}
		}

		for (int i = 0; i < numZeroes; ++i) {
			temp.add(0);
		}

		for (int i = 0; i < nums.length; ++i) {
			nums[i] = temp.get(i);
		}
	}

	// 2 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public void moveZeroes2(int[] nums) {
		int lastNonZeroFoundAt = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				nums[lastNonZeroFoundAt++] = nums[i];
			}
		}

		for (int i = lastNonZeroFoundAt; i < nums.length; ++i) {
			nums[i] = 0;
		}
	}

	// 3 双指针 交换
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public void moveZeroes3(int[] nums) {
		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; ++cur) {
			if (nums[cur] != 0) {
				int temp = nums[lastNonZeroFoundAt];
				nums[lastNonZeroFoundAt] = nums[cur];
				nums[cur] = temp;
				lastNonZeroFoundAt++;
			}
		}
	}

// =====================测试代码===================
	public void test() {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int num : nums) {
			System.out.print(num + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

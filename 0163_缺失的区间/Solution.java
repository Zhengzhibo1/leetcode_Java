import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现=======================
	// 方法 一次遍历
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> resultList = new ArrayList<String>();

		int pre = lower - 1;

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] - pre == 2) {
				resultList.add(String.valueOf(pre + 1));
			} else if (nums[i] - pre > 2) {
				resultList.add((pre + 1) + "->" + (nums[i] - 1));
			}

			pre = nums[i];
		}

		if (upper - pre == 1) {
			resultList.add(String.valueOf(upper));
		} else if (upper - pre > 1) {
			resultList.add("" + (pre + 1) + "->" + upper);
		}

		return resultList;
	}

// ===================测试代码=======================
	public void test() {
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0, upper = 99;
		List<String> resultList = findMissingRanges(nums, lower, upper);
		for (String str : resultList) {
			System.out.print(str + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

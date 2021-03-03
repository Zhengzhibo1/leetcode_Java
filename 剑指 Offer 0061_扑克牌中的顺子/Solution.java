import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现======================
	// 问题转换：1、5张卡牌中，除了大小王，其余不能重复
	// 2、5张卡牌中，最大值-最小值 < 5

	// 方法1 哈希表
	// 时间复杂度O(1)，因为最多只有5张卡牌
	// 空间复杂度O(1)，因为最多只有5张卡牌
	public boolean isStraight(int[] nums) {

		// 边界条件判断
		if (nums == null || nums.length < 5) {
			return false;
		}

		Set<Integer> set = new HashSet<Integer>();
		int min = 14, max = 1;
		for (int num : nums) {
			if (num == 0) {
				continue;
			}
			if (set.contains(num)) {
				// 出现除大小王之外的重复卡牌
				return false;
			}
			set.add(num);

			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		return max - min < 5;
	}

	// 排序
	public boolean isStraight2(int[] nums) {
		// 边界条件判断
		if (nums == null || nums.length < 5) {
			return false;
		}

		Arrays.sort(nums);

		// 统计大小王数量
		int joker = 0;

		for (int i = 0; i < 4; ++i) {
			if (nums[i] == 0) {
				joker++;
				continue;
			}

			// 出现重复卡牌
			if (nums[i] == nums[i + 1]) {
				return false;
			}
		}

		return nums[4] - nums[joker] < 5;
	}

// ===================测试代码======================
	public void test() {
		int[] nums = { 0, 0, 1, 2, 5 };
		boolean result = isStraight2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

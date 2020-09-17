import java.util.HashMap;
import java.util.Map;

public class Solution {

// ====================算法实现===================
	// 1 枚举
	// 时间复杂度O(n^2)
	// 空间复杂度O(1)
	public int subarraySum(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int count = 0;

		for(int start = 0; start < nums.length; ++start) {
			int curSum = 0;
			for(int end = start; end < nums.length; ++end) {
				curSum += nums[end];
				if(curSum == k) {
					count++;
				}
			}
		}

		return count;
	}

	// 2 前缀和 + 字典
	// 如果当前和与k之间的差值，能在前缀和中找到，代表有可删除的前缀
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int subarraySum2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int count = 0;
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		
		for(int i = 0; i < nums.length; ++i) {
			preSum += nums[i];
			count += map.getOrDefault(preSum - k, 0);
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}
		
		return count;
	}
	
// ====================测试代码===================
	public void test() {
		int[] nums = { -1, -1, 1};
		int k = 0;
		int result = subarraySum2(nums, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

import java.util.HashMap;
import java.util.Map;

public class Solution {
// 总结：遍历两次数组，第一次遍历建立哈希表，便于O(1)时间内查找元素
// 第二次遍历数组，查找哈希表中是否存在target - 当前元素的值。
// 时间复杂度为O(n);
// 空间复杂度为O(n);
// ====================算法实现=====================
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; ++i) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}

		return null;
	}

// ====================测试代码======================
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 2, 7, 11, 15 };
		int[] result = s.twoSum(nums, 9);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

}

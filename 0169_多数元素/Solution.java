import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

// =================算法实现=================
	// 1 排序
	// 时间复杂度O(NlogN)，数组排
	// 空间复杂度O(logN)，使用语言自带的排序算法，需要O(logN)的栈空间
	// 若自己写排序，则仅需O(1)
	public int majorityElement(int[] nums) {

		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// 2 哈希表
	// 时间复杂度O(n)，每个元素遍历一次，查询的时候遍历次数不超过数组长度n
	// 空间复杂度O(n)，哈希表最多n-（n/2）个不同元素
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}

		return majorityEntry.getKey();
	}

	// 3 摩尔投票法
	// 时间复杂度O(n)，数组每个元素遍历一次
	// 空间复杂度O(1)
	public int majorityElement3(int[] nums) {
		int count = 0;
		Integer candidate = null;
		for (int i : nums) {
			if (count == 0) {
				candidate = i;
			}
			if (i == candidate) {
				count++;
			} else {
				count--;
			}
		}

		return candidate;
	}

// =================测试代码=================
	public void test() {
		int[] nums = { 3, 2, 3 };
		int result = majorityElement2(nums);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

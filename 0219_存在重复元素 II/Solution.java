import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

// ====================算法实现===================
	// 方法1 字典
	// 时间复杂度O(n)，一次遍历，n为数组长度
	// 空间复杂度O(n)，需要字典
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		// 边界条件判断
		if (nums == null || nums.length <= 1) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; ++i) {

			// 如果字典无该数字
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else { // 如果字典有该数字
				int temp = map.get(nums[i]);
				if ((i - temp) <= k) {
					return true;
				} else { // 如果不符合条件，更新该值
					map.put(nums[i], i);
				}
			}
		}

		return false;
	}

	// 方法2 滑动窗口
	// 时间复杂度O(n)
	// 空间复杂度O(MIN(n,k))
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		// 边界条件判断
		if (nums == null || nums.length <= 1) {
			return false;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
				if (set.size() > k) {
					set.remove(nums[i - k]);
				}
			}
		}

		return false;
	}

// ====================测试代码===================
	public void test1() {
		int nums[] = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		boolean result = containsNearbyDuplicate2(nums, k);
		System.out.println(result);

	}

	public void test2() {
		int nums[] = { 1, 2, 3, 1 };
		int k = 3;
		boolean result = containsNearbyDuplicate(nums, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

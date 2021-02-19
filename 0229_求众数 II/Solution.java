import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

// ===================算法实现=======================
	// 方法1 哈希表
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public List<Integer> majorityElement(int[] nums) {

		List<Integer> resultList = new ArrayList<Integer>();

		// 边界条件判断
		if (nums == null || nums.length == 0) {
			return resultList;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int threshold = nums.length / 3;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > threshold) {
				resultList.add(e.getKey());
			}
		}

		return resultList;
	}

	// 方法2 摩尔投票法
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public List<Integer> majorityElement2(int[] nums) {

		List<Integer> resultList = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return resultList;
		}

		int candidate1 = nums[0];
		int count1 = 0;
		int candidate2 = nums[0];
		int count2 = 0;

		// 配对阶段
		for (int i = 0; i < nums.length; ++i) {

			if (nums[i] == candidate1) {
				count1++;
				continue;
			}

			if (nums[i] == candidate2) {
				count2++;
				continue;
			}

			if (count1 == 0) {
				candidate1 = nums[i];
				count1++;
				continue;
			}

			if (count2 == 0) {
				candidate2 = nums[i];
				count2++;
				continue;
			}

			count1--;
			count2--;
		}

		count1 = 0;
		count2 = 0;
		// 计数
		int threshold = nums.length / 3;
		for (int i = 0; i < nums.length; ++i) {

			if (nums[i] == candidate1) {
				count1++;
				continue;
			}

			if (nums[i] == candidate2) {
				count2++;
				continue;
			}
		}

		if (count1 > threshold) {
			resultList.add(candidate1);
		}

		if (count2 > threshold) {
			resultList.add(candidate2);
		}

		return resultList;
	}

// ===================测试代码=======================
	public void test()
    {
    	int[] nums = {1,1,1,3,3,2,2,2};
    	List<Integer> resultList = majorityElement2(nums);
    	for(int i : resultList) {
    		System.out.print(i + "\t");
    	}
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

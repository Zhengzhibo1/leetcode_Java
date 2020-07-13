import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

// ====================算法实现=================
	// 1、哈希表
	// 时间复杂度：O(m + n),需要遍历两个数组
	// 空间复杂度：O(Min(m,n))用较短的数组长度创建哈希表和临时结果数组
	public int[] intersect(int[] nums1, int[] nums2) {

		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[] {};
		}
		// 使nums1为较短的数组
		if (nums2.length < nums1.length) {
			return intersect(nums2, nums1);
		}

		// 创建哈希表存放较短的数组，节省空间
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			int count = map.getOrDefault(i, 0);
			count += 1;
			map.put(i, count);
		}

		// 创建结果数组
		int[] result = new int[nums1.length];
		// 结果数组索引
		int index = 0;
		for (int i : nums2) {
			// 如果map中存在则取其值，若不存在则用0
			int count = map.getOrDefault(i, 0);
			if (count > 0) {
				result[index++] = i;
				count--;
			}
			if (count > 0) {
				map.put(i, count);
			} else {
				map.remove(i);
			}
		}

		// 重新整理数组
		return Arrays.copyOfRange(result, 0, index);
	}

	// 2、排序数组
	// 时间复杂度：O(mlogm + nlogn),对两数组进行排序O(mlogm + nlogn)，遍历两个数组O(m + n)
	// 空间复杂度：O(Min(m,n))用较短的数组长度创建临时结果数组
	public int[] intersect2(int[] nums1, int[] nums2) {

		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[] {};
		}
		// 排序两数组
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		// 创建结果数组
		int[] result = new int[Math.min(nums1.length, nums2.length)];
		// 索引
		int index1 = 0;
		int index2 = 0;
		int index = 0;

		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] > nums2[index2]) {
				index2++;
			} else if (nums1[index1] < nums2[index2]) {
				index1++;
			} else {
				result[index] = nums1[index1];
				index1++;
				index2++;
				index++;
			}
		}

		return Arrays.copyOfRange(result, 0, index);
	}

// ====================测试代码==================
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] result = s.intersect2(nums1, nums2);
		for (int i : result) {
			System.out.print(i + "\t");
		}

	}

}

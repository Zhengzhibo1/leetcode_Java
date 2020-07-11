import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

// ====================算法实现==================
	// 1、暴力搜索 时间复杂度O(n^2) 空间复杂度O(1)，仅一个结果存放需要空间
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> results = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return results;
		}

		for (int i = 0; i < nums.length; ++i) {
			int count = 0;
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[i] > nums[j]) {
					count++;
				}
			}
			results.add(count);
		}

		return results;
	}

	// 2、离散化树状数组
	// 时间复杂度：对去重数组排序O(nlogn)，初始化树状数组O(n)，
	// 树状数组的单词操作O(logn)，对每个元素做一次查询id，单点修改，前缀和查询，总共O(nlogn)
	// 故渐进时间复杂度为 O(nlogn)。
	// 空间复杂度：这里用到的离散化数组、树状数组、哈希表的空间代价都是 O(n)，故渐进空间复杂度为 O(n)。
	// 关于树状数组，https://www.cnblogs.com/xenny/p/9739600.html
	private int[] c;
	private int[] a;

	public List<Integer> countSmaller2(int[] nums) {
		List<Integer> resultList = new ArrayList<Integer>();
		discretization(nums);
		init(nums.length + 5);
		for (int i = nums.length - 1; i >= 0; --i) {
			int id = getId(nums[i]);
			resultList.add(query(id - 1));
			update(id);
		}
		Collections.reverse(resultList);
		return resultList;
	}

	private void init(int length) {
		c = new int[length];
		Arrays.fill(c, 0);
	}

	private int lowBit(int x) {
		return x & (-x);
	}

	private void update(int pos) {
		while (pos < c.length) {
			c[pos] += 1;
			pos += lowBit(pos);
		}
	}

	private int query(int pos) {
		int ret = 0;
		while (pos > 0) {
			ret += c[pos];
			pos -= lowBit(pos);
		}

		return ret;
	}

	private void discretization(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}
		int size = set.size();
		a = new int[size];
		int index = 0;
		for (int num : set) {
			a[index++] = num;
		}
		Arrays.sort(a);
	}

	private int getId(int x) {
		return Arrays.binarySearch(a, x) + 1;
	}

// ====================测试代码=================
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { 6, 5, 5, 2, 3, 6 };
		List<Integer> results = s.countSmaller2(nums);
		for (int i : results) {
			System.out.print(i + "\t");
		}

	}

}

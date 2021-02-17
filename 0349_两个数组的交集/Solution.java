import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现====================
	// 方法 集合法
	// 时间复杂度O(n + m)，n和m分别为两数组的长度
	// 空间复杂度O(MAX(M, N))
	public int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> resultSet = new HashSet<Integer>();
		for (int i : nums1) {
			set.add(i);
		}

		for (int i : nums2) {
			if (set.contains(i)) {
				resultSet.add(i);
			}
		}

		int[] result = new int[resultSet.size()];
		int index = 0;
		for (int i : resultSet) {
			result[index] = i;
			index++;
		}

		return result;
	}

// ===================测试代码====================
	public void test() {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };
		int[] result = intersection(nums1, nums2);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

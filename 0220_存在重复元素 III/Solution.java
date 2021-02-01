import java.util.TreeSet;

public class Solution {

// ===================算法实现=======================
	// 方法 二叉搜索树
	// 时间复杂度O(n log MIN(n, k))，其中n为数组长度，搜索，插入，删除操作所需得时间复杂度为O(log MIN(n,k))
	// 空间复杂度O(MIN(n, k))
	/*
	 * floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null. ceiling(E e)
	 * 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null. 注意：溢出问题，需要将int转换成long类型
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		// 边界条件判断
		if (nums == null || nums.length <= 1) {
			return false;
		}

		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; ++i) {

			// 寻找后继数字
			Integer right = set.ceiling(nums[i]);
			if (right != null && right <= ((long) nums[i] + t)) {
				return true;
			}

			// 寻找前继数字
			Integer left = set.floor(nums[i]);
			if (left != null && left >= ((long) nums[i] - t)) {
				return true;
			}

			// 如果不满足条件，将该数字添加到set中
			set.add(nums[i]);
			// 如果窗口满了，删除最早进入的数字
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}

		return false;
	}

// ===================测试代码=======================
	public void test1() {
		int nums[] = { -2147483648, -2147483647 };
		int t = 3;
		int k = 3;
		boolean result = containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

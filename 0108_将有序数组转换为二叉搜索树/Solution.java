public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现=====================
	// 总结：时间复杂度：O(n)，因为每个数字仅访问一次。
	// 空间复杂度O(log n)，其中n是数组的长度。空间复杂度不考虑返回值，
	// 因此空间复杂度主要取决于递归栈的深度，递归栈的深度是O(log n)。
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return null;
		}
		TreeNode result = sortedArrayToBSTCore(nums, 0, nums.length - 1);
		return result;
	}

	public TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {

		if (start > end) {
			return null;
		}
		// 计算中位数位置，+1 是为了在偶数情况下总是去中间两个数的后一个
		int middle = (start + end + 1) >> 1;

		TreeNode root = new TreeNode(nums[middle]);

		root.left = sortedArrayToBSTCore(nums, start, middle - 1);
		root.right = sortedArrayToBSTCore(nums, middle + 1, end);

		return root;
	}

// =====================测试代码=====================
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode result = s.sortedArrayToBST(nums);
		
	}

}

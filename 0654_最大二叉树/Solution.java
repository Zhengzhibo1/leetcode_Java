public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

// ====================算法实现======================
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root = core(nums, 0, nums.length - 1);

		return root;
	}

	private TreeNode core(int[] nums, int start, int end) {

		if (start > end || end < 0) {
			return null;
		}

		int max = Integer.MIN_VALUE;
		int index = start;
		for (int i = start; i <= end; ++i) {

			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}

		TreeNode root = new TreeNode(max);
		root.left = core(nums, start, index - 1);
		root.right = core(nums, index + 1, end);

		return root;
	}

// ====================测试代码======================
	public void test() {
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = constructMaximumBinaryTree(nums);

		preorder(root);
	}

	private void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

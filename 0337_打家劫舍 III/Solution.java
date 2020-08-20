public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ====================算法实现==================
	// 1 后续遍历 动态规划 滑动数组
	// 时间复杂度O(n)，后序遍历
	// 空间复杂度O(n)，递归栈深度
	public int rob(TreeNode root) {

		int[] rootStatus = dfs(root);
		return Math.max(rootStatus[0], rootStatus[1]);
	}

	public int[] dfs(TreeNode node) {

		if (node == null) {
			return new int[] { 0, 0 };
		}

		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		int selected = node.val + left[1] + right[1];
		int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return new int[] { selected, notSelected };
	}

// ====================测试代码==================
	public void test() {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(1);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.right = node5;

		int result = rob(node1);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

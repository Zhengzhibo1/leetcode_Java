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

// ===================算法实现======================
	// 方法 自底向上 递归
	// 时间复杂度O(n)，其中n为节点数，每个节点遍历一次
	// 空间复杂度O(n)，取决于递归深度
	public boolean isBalanced(TreeNode root) {

		return treeHeight(root) >= 0;
	}

	// 递归求取树的高度
	public int treeHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = treeHeight(node.left);
		int right = treeHeight(node.right);

		// 判断当前节点是否平衡
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

// ===================测试代码======================
	public void test() {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);

		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;

		boolean result = isBalanced(node3);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

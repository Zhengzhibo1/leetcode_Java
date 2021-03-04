public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现======================
	// 方法 递归，二叉树的后序遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		// 如果两节点分别位于当前节点的左右两侧，则返回当前节点
		return root;
	}

// ===================测试代码======================
	public void test() {

		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		node3.left = node5;
		node3.right = node1;
		node5.left = node6;
		node5.right = node2;
		node2.left = node7;
		node2.right = node4;
		node1.left = node0;
		node1.right = node8;

		TreeNode p = node5;
		TreeNode q = node1;
		TreeNode result = lowestCommonAncestor(node3, p, q);
		System.out.println(result.val);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

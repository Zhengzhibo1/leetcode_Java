import java.util.Stack;

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
	int count = 0;
	int res = -1;

	// 1 中序遍历 递归
	// 时间复杂度O(H + K)，H为树的高度
	// 空间复杂度O(H)，递归深度
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		inorder(root, k);

		return res;
	}

	public void inorder(TreeNode root, int k) {
		if (root == null) {
			return;
		}

		inorder(root.left, k);

		count++;
		if (count == k) {
			res = root.val;
		}

		inorder(root.right, k);
	}

	// 2 中序遍历 迭代
	// 时间复杂度O(H + K)，H为树的高度
	// 空间复杂度O(H)
	public int kthSmallest2(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) {
				return root.val;
			}
			root = root.right;
		}
	}

// ===================测试代码=======================
	public void test() {
		TreeNode node3 = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);

		node3.left = node1;
		node3.right = node4;
		node1.right = node2;

		int k = 1;
		int result = kthSmallest2(node3, k);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现====================
	// 方法 中序遍历的倒序
	// 时间复杂度O(n)，n为二叉树的节点数
	// 时间复杂度O(n)，取决于递归深度
	int k, result;

	public int kthLargest(TreeNode root, int k) {

		this.k = k;
		dfs(root);
		return result;

	}

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.right);
		if (k == 0) {
			return;
		}
		if (--k == 0) {
			result = root.val;
			return;
		}

		dfs(root.left);

	}

// ===================测试代码====================
//	   3
//	   / \
//	  1   4
//	   \
//	    2
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node3.left = node1;
		node3.right = node4;
		node1.right = node2;

		int k = 1;
		int result = kthLargest(node3, k);
		System.out.print(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

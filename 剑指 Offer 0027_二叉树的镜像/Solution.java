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
	// 方法 递归
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(n)，取决于递归深度
	public TreeNode mirrorTree(TreeNode root) {

		// 边界条件判断
		if (root == null) {
			return null;
		}

		// 交换左右节点
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;

		root.left = mirrorTree(root.left);
		root.right = mirrorTree(root.right);

		return root;
	}

// ===================测试代码====================
//    4
//  /   \
// 2     7
/// \   / \
//1   3 6   9
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);

		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;
		preorder(node4);
		System.out.println();

		TreeNode root = mirrorTree(node4);
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

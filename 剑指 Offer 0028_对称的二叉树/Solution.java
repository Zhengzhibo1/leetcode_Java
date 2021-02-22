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
	// 方法 递归
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(n)，取决于递归深度
	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}
		return isSymmetricCore(root.left, root.right);
	}

	private boolean isSymmetricCore(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.val != node2.val) {
			return false;
		}

		return isSymmetricCore(node1.left, node2.right) && isSymmetricCore(node1.right, node2.left);
	}

// ===================测试代码======================
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node33 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node44 = new TreeNode(4);

		node1.left = node2;
		node1.right = node22;
		node2.left = node3;
		node2.right = node4;

		node22.left = node44;
		node22.right = node33;

		boolean result = isSymmetric(node1);
		System.out.print(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

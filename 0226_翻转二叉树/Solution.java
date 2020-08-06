import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// =====================算法实现=================
	// 1 递归
	// 时间复杂度O(n)，n为节点数，每个节点访问一次
	// 时间复杂度O(n)，取决于递归深度，最差情况下
	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		invertTreeCore(root);

		return root;
	}

	private void invertTreeCore(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}

		TreeNode tempNode = root.right;
		root.right = root.left;
		root.left = tempNode;

		invertTreeCore(root.left);
		invertTreeCore(root.right);
	}

	// 2 迭代
	// 时间复杂度O(n)
	// 空间复杂度O(n)，最坏情况下，队列包含了树的所有节点
	// 叶子节那层拥有节点n/2个。
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.remove();
			TreeNode tempNode = curNode.left;
			curNode.left = curNode.right;
			curNode.right = tempNode;
			if (curNode.left != null) {
				queue.add(curNode.left);
			}
			if (curNode.right != null) {
				queue.add(curNode.right);
			}
		}

		return root;
	}

// =====================测试代码=================
	// 前序遍历
	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}

	public void test() {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);

		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;

		preorder(node4);

		System.out.println();
		preorder(invertTree(node4));

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

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

// ===================算法实现===================
	// 方法1 递归
	// 时间复杂度O(n)，n为二叉树的节点数
	// 空间复杂度O(n)，取决于递归深度
	int maxDepth = 0;

	public int maxDepth(TreeNode root) {

		// 边界条件判断
		if (root == null) {
			return 0;
		}

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	// 方法2 迭代，层序遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int maxDepth2(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int maxDepth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				TreeNode tempNode = queue.poll();
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}

				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			maxDepth++;
		}

		return maxDepth;
	}

// ===================测试代码===================
//    3
//   / \
//  9  20
//    /  \
//   15   7
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

		int maxDepth = maxDepth2(node3);
		System.out.println(maxDepth);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

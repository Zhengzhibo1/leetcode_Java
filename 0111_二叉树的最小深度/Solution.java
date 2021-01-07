import java.util.LinkedList;
import java.util.Queue;

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

// ===================算法实现=====================
	// 方法1 深度优先搜索 递归
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(n)，取决于递归深度
	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		int minDepth = Integer.MAX_VALUE;

		if (root.left != null) {
			minDepth = Math.min(minDepth, minDepth(root.left));
		}

		if (root.right != null) {
			minDepth = Math.min(minDepth, minDepth(root.right));
		}

		return minDepth + 1;
	}

	// 方法2 宽度优先搜索
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(n)
	public int minDepth2(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			count++;
			for (int i = 0; i < size; ++i) {
				TreeNode tempNode = queue.poll();
				if (tempNode.left == null && tempNode.right == null) {
					return count;
				}

				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}

				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}

			}
		}

		return count;
	}

// ===================测试代码=====================
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

		int minDepth = minDepth2(node3);
		System.out.println(minDepth);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

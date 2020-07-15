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

// ====================算法实现====================
	// 1 递归
	// 时间复杂度：每个节点只访问一次，O(N),N为节点数量
	// 空间复杂度：最差情况例如全是左节点O(N)；
	// 最好情况，树完全平衡O(logN)。
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return left > right ? (left + 1) : (right + 1);
	}

	// 2 BFS
	// 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为O(n)，n为树的节点数。
	// 空间复杂度：队列中元素的个数不超过n，故渐进空间复杂度为O(n)。
	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int depth = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			int curSize = queue.size();
			depth++;
			for (int i = 0; i < curSize; ++i) {
				TreeNode tempNode = queue.poll();
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
		}

		return depth;
	}

// ====================测试代码====================
//  3
//  / \
// 9  20
//   /  \
//  15   7
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

		int depth = maxDepth2(node3);
		System.out.println(depth);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

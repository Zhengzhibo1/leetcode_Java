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

// ====================算法实现==================
	// 1 递归
	// 时间复杂度O(n)，n为树的节点数
	// 空间复杂度O(n),与递归使用的栈空间有关，递归层度不超过n
	public boolean isSymmetric(TreeNode root) {

		return isSymmetricCore(root, root);
	}

	public boolean isSymmetricCore(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.val != root2.val) {
			return false;
		}

		return isSymmetricCore(root1.left, root2.right) && isSymmetricCore(root1.right, root2.left);
	}

	// 2 迭代
	// 时间复杂度O(n)
	// 空间复杂度O(n)，需要一个队列维护节点，队中节点最多不超过n
	public boolean isSymmetric2(TreeNode root) {

		return isSymmetricCore2(root, root);
	}

	public boolean isSymmetricCore2(TreeNode root1, TreeNode root2) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root1);
		queue.add(root2);

		while (!queue.isEmpty()) {
			root1 = queue.poll();
			root2 = queue.poll();
			if (root1 == null && root2 == null) {
				continue;
			}
			if (root1 == null || root2 == null || root1.val != root2.val) {
				return false;
			}
			queue.add(root1.left);
			queue.add(root2.right);

			queue.add(root1.right);
			queue.add(root2.left);
		}

		return true;
	}

// ====================测试代码==================
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(4);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.left = node7;
		node3.right = node5;

		boolean result = isSymmetric(node1);
		System.out.println(result);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

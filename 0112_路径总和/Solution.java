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

// ===================算法实现==================
	// 总结：1、时间复杂度O(N)，其中N是树的节点数，对每个节点访问一次
	// 1、空间复杂度O(H)，其中H是数的高度，空间复杂度主要取决于递归时栈空间的开销。
	// 最坏情况，树成链状，空间复杂度为O(N)。平均情况下树的高度与节点数的对数相关，
	// 空间复杂度为O(logN)。
	// 2、时间复杂度O(N)，其中N是树的节点数，对每个节点访问一次
	// 2、空间复杂度O(N)，其中N是树的节点数，空间复杂度主要取决于队列的开销
	// 队列中元素个数最多不超过树的节点数。
	
	// 1、递归实现，深度优先
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		boolean result = hasPathSumCore(root, sum, 0);
		return result;
	}

	public boolean hasPathSumCore(TreeNode root, int sum, int curSum) {
		curSum += root.val;
		if (curSum == sum && (root.left == null && root.right == null)) {
			return true;
		}
		boolean result = false;
		if (root.left != null) {
			result = hasPathSumCore(root.left, sum, curSum);
		}
		if (!result && root.right != null) {
			result = hasPathSumCore(root.right, sum, curSum);
		}

		return result;
	}

	// 2、宽度优先搜索
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queNode = new LinkedList<TreeNode>();
		Queue<Integer> queVal = new LinkedList<Integer>();
		queNode.offer(root);
		queVal.offer(root.val);
		while (!queNode.isEmpty()) {
			TreeNode curNode = queNode.poll();
			int temp = queVal.poll();
			if (curNode.left == null && curNode.right == null) {
				if (temp == sum) {
					return true;
				}
				continue;
			}
			if (curNode.left != null) {
				queNode.offer(curNode.left);
				queVal.offer(temp + curNode.left.val);
			}
			if (curNode.right != null) {
				queNode.offer(curNode.right);
				queVal.offer(temp + curNode.right.val);
			}
		}
		return false;
	}

// ===================测试代码===================
	public void test() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);

		node5.left = node4;
		node5.right = node8;
		node4.left = node11;
		node11.left = node7;
		node11.right = node2;
		node8.left = node13;
		node8.right = node6;
		node6.right = node1;

		boolean result = hasPathSum2(node5, 22);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

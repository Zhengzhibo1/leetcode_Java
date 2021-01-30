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

// ===================算法实现====================
	// 方法1 递归
	// 时间复杂度O(n)，n位节点数
	// 空间复杂度O(n)，取决于递归深度
	public int sumNumbers(TreeNode root) {
		// 边界条件判断
		if (root == null) {
			return 0;
		}

		return core(root, 0, 0);
	}

	private int core(TreeNode node, int sum, int curSum) {

		curSum = curSum * 10 + node.val;
		int temp = sum;
		if (node.left == null && node.right == null) {
			temp += curSum;
		} else {
			if (node.left != null) {
				temp += core(node.left, sum, curSum);
			}

			if (node.right != null) {
				temp += core(node.right, sum, curSum);
			}
		}

		return temp;
	}

	// 方法2 迭代
	public int sumNumbers2(TreeNode root) {
		// 边界条件判断
		if (root == null) {
			return 0;
		}

		int sum = 0;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> numQueue = new LinkedList<Integer>();
		nodeQueue.add(root);
		numQueue.add(root.val);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int num = numQueue.poll();
			TreeNode leftNode = node.left;
			TreeNode rightNode = node.right;
			if (leftNode == null && rightNode == null) {
				sum += num;
			} else {
				if (leftNode != null) {
					nodeQueue.add(leftNode);
					numQueue.add(num * 10 + leftNode.val);
				}

				if (rightNode != null) {
					nodeQueue.add(rightNode);
					numQueue.add(num * 10 + rightNode.val);
				}
			}
		}

		return sum;
	}

// ===================测试代码====================
	public void test1() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;

		int result = sumNumbers(node1);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

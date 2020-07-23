import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ====================算法实现===================
	// 1 递归
	// 时间复杂度O(n)，遍历每个节点
	// 空间复杂度最快情况O(n)，平均情况O(logN)，由递归深度决定
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		inorderTraversalCore(root, result);

		return result;
	}

	public void inorderTraversalCore(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}

		inorderTraversalCore(root.left, result);
		result.add(root.val);
		inorderTraversalCore(root.right, result);
	}

	// 2 基于栈的遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)，需要一个栈临时存储节点
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curNode = root;

		while (curNode != null || !stack.isEmpty()) {
			while (curNode != null) {
				stack.add(curNode);
				curNode = curNode.left;
			}

			curNode = stack.pop();
			result.add(curNode.val);
			curNode = curNode.right;

		}

		return result;
	}

// ====================测试代码===================
	// 1
	// \
	// 2
	// /
	// 3
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.right = node2;
		node2.left = node3;

		List<Integer> result = inorderTraversal2(node1);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

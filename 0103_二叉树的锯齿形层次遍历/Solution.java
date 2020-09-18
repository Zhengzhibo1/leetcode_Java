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

// ====================算法实现=====================
	// 1 栈
	// 时间复杂度O(n)，n表示节点数
	// 空间复杂度O(n)
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		stack1.add(root);
		// 1表示从左边开始读
		int left = 1;

		List<Integer> res = new ArrayList<Integer>();
		while (!stack1.isEmpty()) {
			TreeNode curNode = stack1.pop();
			res.add(curNode.val);

			if (left == 1) {
				if (curNode.left != null) {
					stack2.add(curNode.left);
				}

				if (curNode.right != null) {
					stack2.add(curNode.right);
				}
			} else {
				if (curNode.right != null) {
					stack2.add(curNode.right);
				}
				if (curNode.left != null) {
					stack2.add(curNode.left);
				}
			}

			if (stack1.isEmpty()) {
				stack1 = stack2;
				stack2 = new Stack<TreeNode>();
				result.add(res);
				res = new ArrayList<Integer>();
				left = 1 - left;
			}
		}

		return result;
	}

// ====================测试代码=====================
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

		List<List<Integer>> result = zigzagLevelOrder(node3);
		for (List<Integer> res : result) {
			for (int i : res) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

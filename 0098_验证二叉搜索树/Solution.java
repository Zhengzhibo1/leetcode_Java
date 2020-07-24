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

// ====================算法实现==================
	// 1 中序遍历
	// 时间复杂度O(n)，n为二叉树节点个数
	// 空间复杂度O(n)，栈最多存储n个节点
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		double inorder = -Double.MAX_VALUE;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}

			root = stack.pop();

			// 中序遍历得到得节点值如果小于等于前一个节点值，则不为二叉搜索树
			if (root.val <= inorder) {
				return false;
			}
			inorder = root.val;
			root = root.right;
		}

		return true;
	}

	// 2 递归
	// 时间复杂度O(n)，n为二叉树节点个数
	// 空间复杂度O(n)，递归深度最多为n
	public boolean isValidBST2(TreeNode root) {
		return dfs(root, null, null);
	}

	public boolean dfs(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}

		int val = node.val;
		if (lower != null && val <= lower) {
			return false;
		}
		if (upper != null && val >= upper) {
			return false;
		}

		return dfs(node.right, val, upper) && dfs(node.left, lower, val);
	}

// ====================测试代码==================
	//  2
	// / \
	// 1  3
	public void test1() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node2.left = node1;
		node2.right = node3;

		boolean result = isValidBST2(node2);
		System.out.println(result);
	}

	//   5
	//  / \
	//  1  4
	//    / \
	//   3   6
	public void test2() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);

		node5.left = node1;
		node5.right = node4;
		node4.left = node3;
		node4.right = node6;

		boolean result = isValidBST2(node5);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

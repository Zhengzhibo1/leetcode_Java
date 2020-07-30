import java.util.Stack;

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

// ====================算法实现================
	// 1 右子树拼接到左子树最右节点
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(1)
	public void flatten(TreeNode node) {
		TreeNode root = node;
		while (root != null) {
			if (root.left == null) {
				root = root.right;
			} else {
				// 找到左子树最右节点
				TreeNode pre = root.left;
				while (pre.right != null) {
					pre = pre.right;
				}

				// 将原来右子树接到左子树最右节点上
				pre.right = root.right;
				// 左子树插到根节点的右子树上
				root.right = root.left;
				// 左节点清空
				root.left = null;
				// 考虑下一个节点
				root = root.right;
			}
		}

	}

	// 2 利用栈的先序遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public void flatten2(TreeNode node) {
		if (node == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();

			if (pre != null) {
				pre.right = temp;
				pre.left = null;
			}

			if (temp.right != null) {
				stack.push(temp.right);
			}

			if (temp.left != null) {
				stack.push(temp.left);
			}

			pre = temp;
		}
	}

// ====================测试代码================
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;
		node5.right = node6;

		flatten(node1);

		TreeNode curNode = node1;
		while (curNode != null) {
			System.out.print(curNode.val + "\t");
			curNode = curNode.right;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

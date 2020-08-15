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

// ====================算法实现====================
	// 1 递归
	// 时间复杂度O(N)，N是两颗树中的节点个数的较小值
	// 时间复杂度O(N)
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}

		t1.val += t2.val;

		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);

		return t1;
	}

	// 2 迭代
	// 时间复杂度O(N)
	// 空间复杂度O(N)，栈
	public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}

		Stack<TreeNode[]> stack = new Stack<TreeNode[]>();
		stack.push(new TreeNode[] { t1, t2 });

		while (!stack.isEmpty()) {
			TreeNode[] t = stack.pop();
			if (t[1] == null) {
				continue;
			}
			t[0].val += t[1].val;
			if (t[0].left == null) {
				t[0].left = t[1].left;
			} else {
				stack.push(new TreeNode[] { t[0].left, t[1].left });
			}
			if (t[0].right == null) {
				t[0].right = t[1].right;
			} else {
				stack.push(new TreeNode[] { t[0].right, t[1].right });
			}
		}

		return t1;
	}

// ====================测试代码====================
	public void test() {
		// tree1
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(2);
		TreeNode node13 = new TreeNode(3);
		TreeNode node15 = new TreeNode(5);

		node11.left = node13;
		node11.right = node12;
		node13.left = node15;

		// tree2
		TreeNode node22 = new TreeNode(2);
		TreeNode node21 = new TreeNode(1);
		TreeNode node23 = new TreeNode(3);
		TreeNode node24 = new TreeNode(4);
		TreeNode node27 = new TreeNode(7);

		node22.left = node21;
		node22.right = node23;
		node21.right = node24;
		node23.right = node27;

		TreeNode result = mergeTrees(node11, node22);
		preorder(result);

	}

	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

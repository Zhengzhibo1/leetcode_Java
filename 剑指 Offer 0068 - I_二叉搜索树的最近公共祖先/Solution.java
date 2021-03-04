public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现=========================
	// 方法1 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}

		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}

		return root;
	}

	// 方法2 迭代
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

		while (root != null) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				break;
			}
		}

		return root;
	}

// ===================测试代码=========================
	// root = [6,2,8,0,4,7,9,null,null,3,5] ，层序遍历
	public void test() {
		TreeNode node6 = new TreeNode(6);
		TreeNode node0 = new TreeNode(0);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node6.left = node2;
		node6.right = node8;
		node2.left = node0;
		node2.right = node4;
		node4.left = node3;
		node4.right = node5;
		node8.left = node7;
		node8.right = node9;

		TreeNode p = node2;
		TreeNode q = node8;

		TreeNode result = lowestCommonAncestor2(node6, p, q);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

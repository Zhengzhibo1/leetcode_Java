public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ===================算法实现===================
	// 方法 一次遍历，如果p，q分别分别位于某一节点两分支时，该节点为最近公共祖先
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		TreeNode result = root;

		while (true) {
			if (result.val > p.val && result.val > q.val) {
				result = result.left;
			} else if (result.val < p.val && result.val < q.val) {
				result = result.right;
			} else {
				break;
			}
		}

		return result;
	}

// ===================测试代码===================
	public void test() {
		TreeNode node0 = new TreeNode(0);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
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
		TreeNode root = node6;

		TreeNode result = lowestCommonAncestor(root, p, q);
		System.out.println(result.val);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

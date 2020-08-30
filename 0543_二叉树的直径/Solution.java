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
	// 1 深度优先搜索
	// 时间复杂度O(n)，其中n为节点数，每个节点遍历一次
	// 空间复杂度O(n)，取决于递归栈的深度，与树的高度有关，最差情况下为O(n)

	// ans代表节点数，路径长度为节点数 - 1
	int ans = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		// 边界条件判断
		if (root == null) {
			return ans;
		}

		ans = 1;
		depth(root);
		return ans - 1;
	}

	// 递归调用
	// 后序遍历
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);

		// 判断当前最大直径节点数
		ans = Math.max(ans, left + right + 1);
		// 返回当前节点的最大深度
		return Math.max(left, right) + 1;
	}

// ===================测试代码===================
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;

		int ans = diameterOfBinaryTree(node1);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

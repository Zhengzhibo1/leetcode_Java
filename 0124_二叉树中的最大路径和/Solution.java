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
	// 1 递归
	// 时间复杂度O(n)，n为节点数，每个节点遍历不超过2次
	// 空间复杂度O(n)，取决于栈递归深度
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		maxGain(root);
		return maxSum;
	}

	public int maxGain(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// 递归计算左右子节点的最大贡献值
		// 仅当贡献值大于0时，才有用
		int leftGain = Math.max(maxGain(root.left), 0);
		int rightGain = Math.max(maxGain(root.right), 0);

		// 节点的最大路径和取决于该节点与该节点左右子节点的最大贡献值
		maxSum = Math.max(maxSum, root.val + leftGain + rightGain);

		return root.val + Math.max(leftGain, rightGain);
	}

// ===================测试代码==================
	public void test() {
		TreeNode node1 = new TreeNode(-10);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;

		int result = maxPathSum(node1);

		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

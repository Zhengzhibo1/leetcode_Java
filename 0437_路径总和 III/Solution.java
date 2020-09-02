import java.util.HashMap;
import java.util.Map;

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

// ====================算法实现==================
	// 1 前缀和 递归 回溯
	// 时间复杂度O(n)，n为节点数，每个节点遍历一次
	// 空间复杂度O(n)，字典存放前缀和
	public int pathSum(TreeNode root, int sum) {

		// 字典存放前缀和
		Map<Integer, Integer> prefixSumCount = new HashMap<Integer, Integer>();
		// 前缀和为0的一条路径
		prefixSumCount.put(0, 1);

		return recursionPathSum(root, prefixSumCount, sum, 0);
	}

	public int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int curSum) {

		// 递归中止条件
		if (node == null) {
			return 0;
		}

		int result = 0;
		// 当前和
		curSum += node.val;

		result += prefixSumCount.getOrDefault(curSum - target, 0);
		prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

		result += recursionPathSum(node.left, prefixSumCount, target, curSum);
		result += recursionPathSum(node.right, prefixSumCount, target, curSum);

		// 去除当前节点前缀和数量， 回溯
		prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) - 1);
		return result;
	}

// ===================测试代码===================
	public void test() {
		TreeNode node31 = new TreeNode(3);
		TreeNode node21 = new TreeNode(-2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node11 = new TreeNode(11);

		TreeNode node32 = new TreeNode(3, node31, node21);
		TreeNode node22 = new TreeNode(2, null, node1);
		TreeNode node5 = new TreeNode(5, node32, node22);
		TreeNode node33 = new TreeNode(-3, null, node11);
		TreeNode node10 = new TreeNode(10, node5, node33);

		int result = pathSum(node10, 8);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

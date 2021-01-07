import java.util.ArrayList;
import java.util.List;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// ====================算法实现======================
	// 方法1 深度优先搜索
	// 时间复杂度O(n^2)，n为节点数，每个节点遍历一次，拷贝答案需要O(n)时间复杂度
	// 空间复杂度O(n)，取决于递归深度
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 边界条件判断
		if (root == null) {
			return result;
		}

		int curSum = 0;
		dfs(root, curSum, result, new ArrayList<Integer>(), sum);
		return result;
	}

	private void dfs(TreeNode root, int curSum, List<List<Integer>> result, List<Integer> temp, int sum) {

		temp.add(root.val);

		// 如果到达叶子节点
		if (root.left == null && root.right == null) {
			if (curSum + root.val == sum) {
				result.add(new ArrayList<Integer>(temp));
			}
		} else {
			// 如果不是叶子节点
			if (root.left != null) {
				dfs(root.left, curSum + root.val, result, temp, sum);
			}

			if (root.right != null) {
				dfs(root.right, curSum + root.val, result, temp, sum);
			}
		}

		temp.remove(temp.size() - 1);
	}

// ====================测试代码======================
	/*
	 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1
	 */
	public void test() {
		TreeNode node51 = new TreeNode(5);
		TreeNode node41 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node13 = new TreeNode(13);
		TreeNode node42 = new TreeNode(4);
		TreeNode node52 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);

		node51.left = node41;
		node51.right = node8;

		node41.left = node11;
		node11.left = node7;
		node11.right = node2;

		node8.left = node13;
		node8.right = node42;
		node42.left = node52;
		node42.right = node1;

		int sum = 22;

		List<List<Integer>> result = pathSum(node51, sum);
		for (List<Integer> ans : result) {
			for (int i : ans) {
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

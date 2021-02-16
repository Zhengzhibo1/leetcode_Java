import java.util.ArrayList;
import java.util.List;

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

// ===================算法实现===================
	// 方法 回溯
	// 空间复杂度O(n)，取决于递归深度
	public List<TreeNode> generateTrees(int n) {

		// 边界条件
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}

		return generateTreesCore(1, n);
	}

	private List<TreeNode> generateTreesCore(int start, int end) {

		List<TreeNode> allTrees = new ArrayList<TreeNode>();

		// 边界条件判断
		if (start > end) {
			allTrees.add(null);
			return allTrees;
		}

		for (int i = start; i <= end; ++i) {

			List<TreeNode> leftTrees = generateTreesCore(start, i - 1);
			List<TreeNode> rightTrees = generateTreesCore(i + 1, end);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode curNode = new TreeNode(i);
					curNode.left = left;
					curNode.right = right;
					allTrees.add(curNode);
				}
			}
		}

		return allTrees;
	}

// ===================测试代码===================
	public void test() {
		int n = 3;
		List<TreeNode> allTrees = generateTrees(n);
		for(TreeNode root : allTrees) {
			preorder(root);
			System.out.println();
		}
	}
	
	private void preorder(TreeNode root) {
		if(root == null) {
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

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

// ===================算法实现=======================
	// 方法 回溯
	// 时间复杂度O(n)，n为二叉树的节点数，每个节点遍历一次
	// 空间复杂度O(n)，取决于递归深度
	List<List<Integer>> resultList = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		pathSumCore(root, sum, new ArrayList<Integer>());
		return resultList;
	}

	// 回溯
	private void pathSumCore(TreeNode root, int curSum, List<Integer> tempList) {
		if (root == null) {
			return;
		}

		tempList.add(root.val);
		curSum -= root.val;
		if (curSum == 0 && root.left == null && root.right == null) {
			resultList.add(new ArrayList<Integer>(tempList));
		}
		pathSumCore(root.left, curSum, tempList);
		pathSumCore(root.right, curSum, tempList);
		tempList.remove(tempList.size() - 1);

	}

// ===================测试代码=======================
//    5
//   / \
//  4   8
	public void test() {
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node5 = new TreeNode(5);
		node5.left = node4;
		node5.right = node8;

		int sum = 9;
		List<List<Integer>> resultList = pathSum(node5, sum);
		for (List<Integer> list : resultList) {
			for (int i : list) {
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

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

// ===================算法实现======================
	public List<String> binaryTreePaths(TreeNode root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<String> resultList = new ArrayList<String>();
		if (root == null) {
			return resultList;
		}

		binaryTreePathsCore(root, new ArrayList<Integer>(), list);
		for (List<Integer> tempList : list) {
			StringBuilder sb = new StringBuilder();
			for (int i : tempList) {
				sb.append(i);
				sb.append("->");
			}
			resultList.add(sb.toString().substring(0, sb.length() - 2));
		}

		return resultList;
	}

	private void binaryTreePathsCore(TreeNode root, List<Integer> tempList, List<List<Integer>> list) {

		tempList.add(root.val);
		if (root.left == null && root.right == null) {
			// 根节点
			list.add(new ArrayList<>(tempList));
		}

		if (root.left != null) {
			binaryTreePathsCore(root.left, tempList, list);
		}

		if (root.right != null) {
			binaryTreePathsCore(root.right, tempList, list);
		}

		tempList.remove(tempList.size() - 1);
	}

// ===================测试代码======================
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.right = node5;

		List<String> resultList = binaryTreePaths(node1);
		for (String s : resultList) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

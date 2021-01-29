import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

// ====================算法实现=====================
	// 方法1 递归
	// 时间复杂度O(n)，其中n为节点数
	// 空间复杂度O(n)，取决于递归深度
	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		postorder(root, result);
		return result;
	}

	public void postorder(TreeNode root, List<Integer> result) {

		if (root == null) {
			return;
		}

		postorder(root.left, result);
		postorder(root.right, result);
		result.add(root.val);
	}

	// 方法2 迭代
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public List<Integer> postorderTraversal2(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode tempNode = root;
		TreeNode preNode = null;
		while (!queue.isEmpty() || tempNode != null) {

			while (tempNode != null) {
				queue.add(tempNode);
				tempNode = tempNode.left;
			}

			tempNode = queue.pollLast();

			if (tempNode.right == null || tempNode.right == preNode) {
				result.add(tempNode.val);
				preNode = tempNode;
				tempNode = null;

			} else {
				queue.add(tempNode);
				tempNode = tempNode.right;
			}
		}

		return result;
	}

// ====================测试代码=====================
	/*
	 1 
	/ \ 
   2    3 
  / 
 4 
 /\ 
5 6
	 */
	public void test1() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		node4.right = node6;

		List<Integer> result = postorderTraversal2(node1);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

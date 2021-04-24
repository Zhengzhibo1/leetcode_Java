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

// ===================算法实现====================
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.offerLast(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; ++i) {
				TreeNode tempNode = deque.pollFirst();
				if (tempNode.left != null) {
					deque.offerLast(tempNode.left);
				}
				if (tempNode.right != null) {
					deque.offerLast(tempNode.right);
				}
				if (i == size - 1) {
					result.add(tempNode.val);
				}
			}
		}

		return result;
	}

// ===================测试代码====================
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.right = node5;
		node3.right = node4;

		List<Integer> result = rightSideView(node1);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

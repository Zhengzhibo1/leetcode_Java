import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

// ===================算法实现======================
	// 方法 迭代
	// 时间复杂度O(n)，n为二叉树节点数，每个节点遍历一次
	// 空间复杂度O(n)
	public int[] levelOrder(TreeNode root) {

		// 边界条件判断
		if (root == null) {
			return new int[0];
		}

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		List<Integer> ans = new ArrayList<Integer>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			TreeNode tempNode = deque.pollFirst();
			ans.add(tempNode.val);

			if (tempNode.left != null) {
				deque.offerLast(tempNode.left);
			}

			if (tempNode.right != null) {
				deque.offerLast(tempNode.right);
			}
		}

		int[] result = new int[ans.size()];
		for (int i = 0; i < ans.size(); ++i) {
			result[i] = ans.get(i);
		}

		return result;
	}

// ===================测试代码======================
//    3
//   / \
//  9  20
//    /  \
//   15   7
	public void test() {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);

		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;

		int[] result = levelOrder(node3);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	// 时间复杂度O(n)，n为二叉树的节点数，每个节点遍历一次
	// 空间复杂度O(n)，队列所需空间
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (root == null) {
			return resultList;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> tempList = new ArrayList<Integer>();
			int length = queue.size();
			for (int i = 0; i < length; ++i) {
				TreeNode tempNode = queue.poll();
				tempList.add(tempNode.val);

				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}

			resultList.add(tempList);
		}

		return resultList;
	}

// ===================测试代码======================
//  3
// / \
//9  20
//  /  \
// 15   7
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

		List<List<Integer>> resultList = levelOrder(node3);
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

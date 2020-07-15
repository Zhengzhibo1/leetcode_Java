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

// ====================算法实现===============
	// 总结：两种算法复杂度一样，记树上所有节点个数为n。
	// 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为O(n)。
	// 空间复杂度：队列中元素的个数不超过n，故渐进空间复杂度为O(n)。
	// 1 宽度优先遍历 利用两个数字记录当前层节点数与下一层节点数
	public List<List<Integer>> levelOrder(TreeNode root) {
		// 边界条件判定
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (root == null) {
			return results;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		// 当前层节点数
		int curIndex = 1;
		// 下一层节点数
		int nextIndex = 0;
		// 存放每层节点值
		List<Integer> result = new ArrayList<Integer>();

		while (!queue.isEmpty()) {

			TreeNode tempNode = queue.poll();
			result.add(tempNode.val);
			curIndex--;
			if (tempNode.left != null) {
				queue.add(tempNode.left);
				nextIndex++;
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
				nextIndex++;
			}

			if (curIndex == 0) {
				curIndex = nextIndex;
				nextIndex = 0;
				results.add(result);
				result = new ArrayList<Integer>();
			}
		}

		return results;
	}

	// 2 改进版宽度优先遍历 每次取出一层节点
	public List<List<Integer>> levelOrder2(TreeNode root) {
		// 边界条件判定
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (root == null) {
			return results;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int curSize = queue.size();
			List<Integer> result = new ArrayList<Integer>();
			for (int i = 0; i < curSize; ++i) {
				TreeNode tempNode = queue.poll();
				result.add(tempNode.val);
				// 添加左右非空节点到队列中
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			results.add(result);
		}

		return results;
	}

// ====================测试代码===============
//    3
//    / \
//   9  20
//     /  \
//    15   7
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

		List<List<Integer>> results = levelOrder2(node3);
		for (List<Integer> result : results) {
			for (int j : result) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

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
	// 方法 层序遍历，每次遍历结果插入到链表头部即可
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(n),队列
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		// 链表结构
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		// 边界条件判断
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> ans = new ArrayList<Integer>();
			int n = queue.size();
			// 遍历每层结果
			for (int i = 0; i < n; ++i) {
				TreeNode tempNode = queue.poll();
				ans.add(tempNode.val);
				// 将左右节点添加到队列中
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			}
			// 将层序边界结果添加到链表头部
			result.add(0, ans);
		}

		return result;
	}

// ===================测试代码======================
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

		List<List<Integer>> result = levelOrderBottom(node3);
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

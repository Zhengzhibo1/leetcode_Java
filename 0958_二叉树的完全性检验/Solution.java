import java.util.LinkedList;
import java.util.Queue;

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

// ===================算法实现=====================
	// 方法：层序遍历，完全二叉树当前节点若不为空，序号上的前一个节点不应该为空
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public boolean isCompleteTree(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode preNode = root;
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			if (preNode == null && tempNode != null) {
				return false;
			}
			if (tempNode != null) {
				queue.add(tempNode.left);
				queue.add(tempNode.right);
			}

			preNode = tempNode;
		}

		return true;
	}

// ===================测试代码=====================
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package leetcode0100;

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

// ====================算法实现====================
	// 方法1 宽度优先搜索
	// 时间复杂度O(MIN(M , N))，M,N为节点数
	// 空间复杂度O(MIN(M , N))
	public boolean isSameTree(TreeNode p, TreeNode q) {

		// 边界条件判断
		// 两个节点都为空
		if (p == null && q == null) {
			return true;
		}
		// 两个节点中有一个为空
		if (p == null || q == null) {
			return false;
		}

		TreeNode tempNode1 = p;
		TreeNode tempNode2 = q;

		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.add(tempNode1);
		queue2.add(tempNode2);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {

			tempNode1 = queue1.poll();
			tempNode2 = queue2.poll();

			if (tempNode1.val != tempNode2.val) {
				return false;
			}

			TreeNode leftNode1 = tempNode1.left;
			TreeNode rightNode1 = tempNode1.right;
			TreeNode leftNode2 = tempNode2.left;
			TreeNode rightNode2 = tempNode2.right;
			// 如果两个左节点仅一个存在
			if (leftNode1 == null ^ leftNode2 == null) {
				return false;
			}
			if (rightNode1 == null ^ rightNode2 == null) {
				return false;
			}
			if (leftNode1 != null) {
				queue1.add(leftNode1);
			}
			if (leftNode2 != null) {
				queue2.add(leftNode2);
			}
			if (rightNode1 != null) {
				queue1.add(rightNode1);
			}
			if (rightNode2 != null) {
				queue2.add(rightNode2);
			}
		}

		return true;
	}

	// 方法2 深度优先搜索，递归
	// 时间复杂度O(MIN(M , N))，M,N为节点数
	// 空间复杂度O(MIN(M , N))
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		// 边界条件判断
		// 两个节点都为空
		if (p == null && q == null) {
			return true;
		}
		// 两个节点中有一个为空
		if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
	}

// ====================测试代码====================
//     1         1
//    / \       / \
//   2   3     2   3
	public void test1() {
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(2);
		TreeNode node13 = new TreeNode(3);
		node11.left = node12;
		node11.right = node13;

		TreeNode node21 = new TreeNode(1);
		TreeNode node22 = new TreeNode(2);
		TreeNode node23 = new TreeNode(3);
		node21.left = node22;
		node21.right = node23;

		boolean result = isSameTree(node11, node21);
		System.out.println("Test1：" + result);
	}

//	   1         1
//    /           \
//   2             2
	public void test2() {
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(2);
		node11.left = node12;

		TreeNode node21 = new TreeNode(1);
		TreeNode node22 = new TreeNode(2);
		node21.right = node22;

		boolean result = isSameTree2(node11, node21);
		System.out.println("Test2：" + result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();
		s.test2();

	}

}

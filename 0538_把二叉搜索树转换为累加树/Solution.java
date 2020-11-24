import java.util.Stack;

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

// ====================算法实现======================
	// 遍历顺序：右->中->左
	// 两种实现方式：递归、迭代

	// 方法1 递归
	// 定义一个全局变量
	int val = 0;

	public TreeNode convertBST(TreeNode root) {

		// 边界条件判断
		if (root == null) {
			return root;
		}

		dfs(root);
		return root;
	}

	// 递归实现
	private void dfs(TreeNode node) {
		// 递归
		if (node.right != null) {
			dfs(node.right);
		}

		// 更新值
		node.val += val;
		val = node.val;

		if (node.left != null) {
			dfs(node.left);
		}
	}

	// 方法2 迭代
	public TreeNode convertBST2(TreeNode root) {

		// 边界条件判断
		if (root == null) {
			return root;
		}
		int value = 0;
		// 存放节点
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		TreeNode tempNode = root.right;
		while (tempNode != null || !stack.isEmpty()) {
			if (tempNode != null) {
				stack.add(tempNode);
				tempNode = tempNode.right;
			} else {
				tempNode = stack.pop();
				tempNode.val += value;
				value = tempNode.val;
				tempNode = tempNode.left;
			}
		}
		return root;
	}

// ====================测试代码======================
//           4
//          / \
//         1   6
//        / \  / \
//       0  2  5  7
//           \     \
//            3     8
	
	
	public void test() {
		// 创建二叉树
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		node4.left = node1;
		node4.right = node6;
		
		node1.left = node0;
		node1.right = node2;
		
		node2.right = node3;
		
		node6.left = node5;
		node6.right = node7;
		
		node7.right = node8;
		
		TreeNode root = convertBST2(node4);
		// 前序遍历打印结果
		preorderPrint(root);
		
	}
	
	private void preorderPrint(TreeNode root) {
		
		System.out.print(root.val + "\t");
		if(root.left != null) {
			preorderPrint(root.left);
		}
		
		if(root.right != null) {
			preorderPrint(root.right);
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

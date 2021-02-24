public class Solution {
	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}

// ===================算法实现======================
	// 方法 递归 + 中序遍历
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	Node preNode, head;

	public Node treeToDoublyList(Node root) {

		// 边界条件判断
		if (root == null) {
			return null;
		}

		preNode = null;
		inorder(root);

		// 连接首尾节点
		head.left = preNode;
		preNode.right = head;

		return head;
	}

	private void inorder(Node curNode) {
		if (curNode == null) {
			return;
		}

		inorder(curNode.left);
		if (preNode == null) {
			head = curNode;
		} else {
			preNode.right = curNode;
		}

		curNode.left = preNode;

		preNode = curNode;
		inorder(curNode.right);
	}

// ===================测试代码======================
	public void test() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		node4.left = node2;
		node4.right = node5;

		node2.left = node1;
		node2.right = node3;

		Node head = treeToDoublyList(node4);

		boolean[] flags = new boolean[5];
		while (head != null && !flags[head.val - 1]) {
			System.out.print(head.val + "\t");
			flags[head.val - 1] = true;
			head = head.right;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

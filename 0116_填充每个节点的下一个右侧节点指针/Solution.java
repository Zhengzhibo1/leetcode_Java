import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

// ====================算法实现===================
	// 1 队列，宽度优先遍历bfs
	// 时间复杂度O(n)，n为节点数，每个节点遍历一次
	// 空间复杂度O(n)，最差情况
	public Node connect(Node root) {

		// 边界条件判断
		if (root == null) {
			return null;
		}

		// 哨兵节点
		Node preNode = new Node(-1);
		preNode.next = root;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		int current = 1;
		int next = 0;

		while (!queue.isEmpty()) {
			current--;
			Node tempNode = queue.poll();
			if (current > 0) {
				tempNode.next = queue.peek();
			}

			if (tempNode.left != null) {
				queue.add(tempNode.left);
				next++;
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
				next++;
			}

			if (current == 0) {
				current = next;
				next = 0;
			}
		}
		return preNode.next;
	}

	// 2
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public Node connect2(Node root) {
		// 边界条件判断
		if (root == null) {
			return null;
		}

		Node leftNode = root;

		while (leftNode.left != null) {

			Node head = leftNode;

			while (head != null) {
				// 连接同一父节点的左右子节点
				head.left.next = head.right;

				// 连接相邻节点的右子节点和左子节点
				if (head.next != null) {
					head.right.next = head.next.left;
				}

				head = head.next;
			}

			leftNode = leftNode.left;
		}

		return root;
	}

// ====================测试代码===================
	public void test() {
		Node node7 = new Node(7);
		Node node6 = new Node(6);
		Node node3 = new Node(3, node6, node7, null);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node2 = new Node(2, node4, node5, null);
		Node node1 = new Node(1, node2, node3, null);

		Node result = connect2(node1);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

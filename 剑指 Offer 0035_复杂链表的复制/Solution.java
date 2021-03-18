public class Solution {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

// ===================算法实现======================
	// 方法 原链表基础上复制，再进行拆分
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public Node copyRandomList(Node head) {

		// 边界条件判断
		if (head == null) {
			return head;
		}

		// 复制
		Node tempNode = head;
		while (tempNode != null) {
			Node copyNode = new Node(tempNode.val);
			copyNode.next = tempNode.next;
			tempNode.next = copyNode;

			tempNode = copyNode.next;
		}

		// 连接复制节点的随机指针
		tempNode = head;
		while (tempNode != null) {
			Node copyNode = tempNode.next;
			if (tempNode.random != null) {
				copyNode.random = tempNode.random.next;
			}
			tempNode = copyNode.next;
		}

		// 拆分链表
		Node copyHead = head.next;
		Node copyNode = copyHead;
		tempNode = head;
		while (tempNode != null) {
			tempNode.next = copyNode.next;
			tempNode = tempNode.next;

			if (copyNode.next != null) {
				copyNode.next = tempNode.next;
				copyNode = copyNode.next;
			}
		}

		return copyHead;
	}

// ===================测试代码======================
	public void test() {
		Node node7 = new Node(7);
		Node node13 = new Node(13);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node1 = new Node(1);

		node7.next = node13;
		node13.next = node11;
		node11.next = node10;
		node10.next = node1;

		node13.random = node7;
		node11.random = node1;
		node10.random = node11;
		node1.random = node7;

		Node copyHead = copyRandomList(node7);
		Node tempNode = copyHead;
		while (tempNode != null) {
			System.out.print(tempNode.val + "\t");
			tempNode = tempNode.next;
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

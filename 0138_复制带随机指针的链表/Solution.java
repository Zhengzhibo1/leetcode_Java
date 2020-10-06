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

// ====================算法实现====================
	// 1 复制拆分
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public Node copyRandomList(Node head) {

		cloneNodes(head);
		connectRandomNode(head);
		return reconnectNodes(head);
	}

	// 第一步复制节点
	public void cloneNodes(Node head) {
		Node pNode = head;
		while (pNode != null) {
			Node cloneNode = new Node(0);
			cloneNode.val = pNode.val;
			cloneNode.next = pNode.next;
			pNode.next = cloneNode;
			pNode = cloneNode.next;
		}
	}

	// 第二步随机指针的复制
	public void connectRandomNode(Node head) {
		Node pNode = head;
		while (pNode != null) {
			Node pClone = pNode.next;
			if (pNode.random != null) {
				pClone.random = pNode.random.next;
			}

			pNode = pClone.next;
		}
	}

	// 第三步拆分两链表
	public Node reconnectNodes(Node head) {
		Node pNode = head;
		Node pCloneHead = null;
		Node pCloneNode = null;

		if (pNode != null) {
			pCloneHead = pNode.next;
			pCloneNode = pNode.next;

			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}

		while (pNode != null) {
			pCloneNode.next = pNode.next;
			pCloneNode = pCloneNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}

		return pCloneHead;
	}

// ====================测试代码====================
	public void test() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		node1.next = node2;
		node2.next = node3;
		node2.random = node1;

		Node cloneNode = copyRandomList(node1);
		while (cloneNode != null) {
			System.out.print(cloneNode.val + "\t");
			cloneNode = cloneNode.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

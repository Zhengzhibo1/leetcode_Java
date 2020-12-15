public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

// ===================算法实现==================
	// 方法 链表成环再断开
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public ListNode rotateRight(ListNode head, int k) {

		// 边界条件判断
		if (head == null) {
			return head;
		}

		// 1 先把链表连成环，并且计算链表的长度
		ListNode tempNode = head;
		int count = 1;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
			count++;
		}
		tempNode.next = head;
		// 2 根据移动数量，找到链表头，并且断开链表
		int index = count - k % count;
		tempNode = head;
		// 在环形链表中，找到链表头的上一个节点
		for (int i = 0; i < index - 1; ++i) {
			tempNode = tempNode.next;
		}
		// 取链表头
		ListNode result = tempNode.next;
		// 断开链表
		tempNode.next = null;

		return result;
	}

// ===================测试代码==================
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		int k = 2;
		ListNode result = rotateRight(node1, k);
		while (result != null) {
			System.out.print(result.val + "\t");
			result = result.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

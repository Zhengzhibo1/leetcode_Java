public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现==================
	// 方法 一次遍历
	// 时间复杂度O(n)，其中n为链表的长度
	// 空间复杂度O(1)
	public ListNode partition(ListNode head, int x) {

		// 哨兵节点
		ListNode beforeHead = new ListNode(0);
		// 小于x的节点
		ListNode before = beforeHead;
		// 哨兵节点
		ListNode afterHead = new ListNode(0);
		// 大于等于x的节点
		ListNode after = afterHead;

		while (head != null) {

			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}

			head = head.next;
		}

		// 拼接两个链表
		after.next = null;
		before.next = afterHead.next;

		return beforeHead.next;
	}

// ====================测试代码==================
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node21 = new ListNode(2);
		ListNode node22 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node4;
		node4.next = node3;
		node3.next = node21;
		node21.next = node5;
		node5.next = node22;

		ListNode tempNode = node1;
		while (tempNode != null) {
			System.out.print(tempNode.val + "\t");
			tempNode = tempNode.next;
		}

		System.out.println();

		int k = 3;
		ListNode newHead = partition(node1, k);
		while (newHead != null) {
			System.out.print(newHead.val + "\t");
			newHead = newHead.next;
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ===================算法实现======================
	// 方法1 迭代
	// 时间复杂度O(n)，n为节点数，每个节点遍历一次
	// 空间复杂度O(1)
	public ListNode reverseList(ListNode head) {

		ListNode preNode = null;
		ListNode curNode = head;

		while (curNode != null) {
			ListNode nextNode = curNode.next;
			curNode.next = preNode;

			preNode = curNode;
			curNode = nextNode;
		}

		return preNode;
	}

	// 方法2 递归
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public ListNode reverseList2(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;

		return newHead;
	}

// ===================测试代码======================
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

		ListNode newHead = reverseList2(node1);
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

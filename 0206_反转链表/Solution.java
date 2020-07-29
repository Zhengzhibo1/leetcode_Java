public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现===============
	// 1 迭代
	// 时间复杂度O(n)，n为节点个数，每个节点访问一次
	// 时间复杂度O(1)
	public ListNode reverseList(ListNode head) {

		ListNode preNode = null;
		ListNode curNode = head;
		ListNode nextNode = null;
		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = preNode;

			preNode = curNode;
			curNode = nextNode;
		}

		return preNode;
	}

	// 2 递归
	// 时间复杂度O(n)，每个节点遍历一次
	// 空间复杂度O(n)，递归深度为n
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = reverseList2(head.next);
		head.next.next = head;
		head.next = null;

		return p;
	}

// ====================测试代码===============
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

		ListNode r = reverseList2(node1);
		while (r != null) {
			System.out.print(r.val + "\t");
			r = r.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

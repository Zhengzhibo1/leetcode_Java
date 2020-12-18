public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现=====================
	// 方法 双指针法，一次遍历
	// 时间复杂度O(n)，n为链表长度
	// 空间复杂度O(1)
	/*
	 * 双指针法，pre先走m-1步到达位置m的前驱节点，pre不动，然后令cur等于pre->next也就是位置m的起始节点（不变），将[m+1,n]
	 * 这段链表由前至后的插入到位置m的前面，也就是pre的后面
	 * 换句话说：我们每次循环就是将cur的next节点插入到pre的后面，这样插了n-m次后，就完成反转了
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {

		// 边界条件判断
		if (head == null) {
			return head;
		}

		// 哨兵节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		// 前驱节点
		ListNode preNode = dummy;
		// 寻找待反转的第一个节点的前驱节点
		for (int i = 1; i < m; ++i) {
			preNode = preNode.next;
		}
		ListNode curNode = preNode.next;

		// 进行反转
		for (int i = m; i < n; ++i) {
			ListNode nextNode = curNode.next;
			curNode.next = nextNode.next;

			nextNode.next = preNode.next;
			preNode.next = nextNode;

		}

		return dummy.next;
	}

// ====================测试代码=====================
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

		int m = 2;
		int n = 4;
		ListNode head = node1;
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();

		head = reverseBetween(node1, m, n);
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

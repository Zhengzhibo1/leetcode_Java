public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现======================
	// 1 遍历2次实现，第一次遍历找到要删除节点的上一个节点位置
	// 第二次遍历删除节点
	// 时间复杂度O(N),其中N为节点数
	// 空间复杂度为O(1)
	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null) {
			return null;
		}
		// 遍历得链表总长度
		int length = 0;
		ListNode tempNode = head;
		while (tempNode != null) {
			length++;
			tempNode = tempNode.next;
		}

		// 如果删除的节点位置超过链表长度
		if (n > length) {
			return null;
		}

		// 如果要删除的节点是头节点
		if (n == length) {
			return head.next;
		}

		// 找到要删除节点的上一节点位置
		int position = length - n;
		tempNode = head;
		for (int i = 1; i < position; ++i) {
			tempNode = tempNode.next;
		}

		// 删除节点
		tempNode.next = tempNode.next.next;

		return head;
	}

	// 遍历一次实现，利用双指针移动，比如删除倒数第二个，
	// 那么只需要将一个指针指向第1+2个节点的指针，
	// 第一个指针指向头节点，然后一起向前走，当第二个节点到达尾部时
	// 第一个节点就是要删除节点的上一个节点
	// 时间复杂度O(N)
	// 空间复杂度O(1)
	public ListNode removeNthFromEnd2(ListNode head, int n) {

		if (head == null) {
			return null;
		}
		ListNode temp1 = head;
		ListNode temp2 = head;

		for (int i = 0; i < n; ++i) {
			temp2 = temp2.next;
		}
		// 删除的是头节点
		if (temp2 == null) {
			return head.next;
		}

		while (temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		temp1.next = temp1.next.next;

		return head;
	}

// ====================测试代码======================
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

		ListNode temp = removeNthFromEnd2(node1, 2);
		while (temp != null) {
			System.out.print(temp.val + "\t");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

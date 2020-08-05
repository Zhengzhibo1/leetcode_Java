public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

// ====================算法实现=================
	// 1 双指针
	// 时间复杂度O(m + n)，m和n分别为两个链表的长度
	// 空间复杂度O(1)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		// 求得两链表的长度
		int lengthA = 0, lengthB = 0;
		for (ListNode tempNode = headA; tempNode != null; tempNode = tempNode.next) {
			lengthA++;
		}

		for (ListNode tempNode = headB; tempNode != null; tempNode = tempNode.next) {
			lengthB++;
		}

		// 计算得两个链表长度的差值
		int length = Math.abs(lengthA - lengthB);

		// 总是让长的链表为indexA
		ListNode indexA = headA;
		ListNode indexB = headB;
		if (lengthA < lengthB) {

			indexA = headB;
			indexB = headA;
		}

		// 长链表先走差值步
		for (int i = 0; i < length; ++i) {
			indexA = indexA.next;
		}

		// 同时移动两个链表上的指针，判断节点是否相等
		while (indexA != null && indexB != null) {
			if (indexA == indexB) {
				return indexA;
			}
			indexA = indexA.next;
			indexB = indexB.next;
		}

		return null;
	}

// ====================测试代码=================
	public void test() {
		ListNode nodeB5 = new ListNode(5);
		ListNode nodeB0 = new ListNode(0);
		ListNode nodeB1 = new ListNode(1);

		ListNode nodeA4 = new ListNode(4);
		ListNode nodeA1 = new ListNode(1);

		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node8 = new ListNode(8);

		nodeB5.next = nodeB0;
		nodeB0.next = nodeB1;
		nodeB1.next = node8;
		node8.next = node4;
		node4.next = node5;

		nodeA4.next = nodeA1;
		nodeA1.next = node8;

		ListNode result = getIntersectionNode(nodeA4, nodeB5);
		System.out.println(result.val);

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

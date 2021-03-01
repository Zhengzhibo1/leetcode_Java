public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

// ===================算法实现===================
	// 方法1 双指针 多次遍历
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		// 边界条件判断
		if (headA == null || headB == null) {
			return null;
		}

		// 分别计算两链表的长度
		int lengthA = 0;
		ListNode tempNode = headA;
		while (tempNode != null) {
			lengthA++;
			tempNode = tempNode.next;
		}

		int lengthB = 0;
		tempNode = headB;
		while (tempNode != null) {
			lengthB++;
			tempNode = tempNode.next;
		}

		ListNode tempNodeA = headA;
		ListNode tempNodeB = headB;
		if (lengthA > lengthB) {
			for (int i = 0; i < lengthA - lengthB; ++i) {
				tempNodeA = tempNodeA.next;
			}
		} else if (lengthA < lengthB) {
			for (int i = 0; i < lengthB - lengthA; ++i) {
				tempNodeB = tempNodeB.next;
			}
		}

		while (tempNodeA != tempNodeB) {
			tempNodeA = tempNodeA.next;
			tempNodeB = tempNodeB.next;
		}

		// 如果没交点的话会在NULL处相遇

		return tempNodeA;
	}

	// 方法2 一次遍历
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

		// 边界条件判断
		if (headA == null || headB == null) {
			return null;
		}

		ListNode tempNodeA = headA;
		ListNode tempNodeB = headB;

		while (tempNodeA != tempNodeB) {
			tempNodeA = tempNodeA == null ? headB : tempNodeA.next;
			tempNodeB = tempNodeB == null ? headA : tempNodeB.next;
		}

		return tempNodeA;
	}

// ===================测试代码===================
//     3 - 1 - 8 - 4 - 5
// 9 - 0 - 1 - 8 - 4 - 5
	public void test() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);

		node3.next = node1;
		node1.next = node8;
		node8.next = node4;
		node4.next = node5;

		node9.next = node0;
		node0.next = node1;
		node8.next = node4;
		node4.next = node5;

		ListNode result = getIntersectionNode2(node3, node9);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

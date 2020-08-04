import java.util.HashSet;
import java.util.Set;

public class Solution {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

// ====================算法实现=================
	// 1 双指针
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public ListNode detectCycle(ListNode head) {

		ListNode tempNode = hasCycle(head);
		if (tempNode == null) {
			return null;
		}

		// 计算环内节点个数
//		int count = 1;
//		ListNode cycleNode = tempNode.next;
//		while (cycleNode != tempNode) {
//			count++;
//			cycleNode = cycleNode.next;
//		}

		// 慢指针从头节点出发，快指针从环内第一次相遇节点出发
		// 相遇的位置即位环入口节点

		ListNode index1 = head;
//		ListNode index2 = head;
		ListNode index2 = tempNode;
		// 快指针先走环内节点数步
//		for (int i = 0; i < count; ++i) {
//			index2 = index2.next;
//		}

		// 两指针同时移动，相等的地方即位环入口节点
		while (index1 != index2) {
			index1 = index1.next;
			index2 = index2.next;
		}

		return index1;
	}

	public ListNode hasCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode index1 = head.next;
		if (index1 == null) {
			return null;
		}
		ListNode index2 = index1.next;

		while (index1 != null && index2 != null) {
			if (index1 == index2) {
				return index1;
			}

			index1 = index1.next;
			index2 = index2.next;
			if (index2 != null) {
				index2 = index2.next;
			}

		}

		return null;
	}

	// 2 哈希表
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public ListNode detectCycle2(ListNode head) {

		Set<ListNode> set = new HashSet<ListNode>();
		ListNode curNode = head;
		while (curNode != null) {
			if (set.contains(curNode)) {
				return curNode;
			} else {
				set.add(curNode);
			}
			curNode = curNode.next;
		}

		return null;
	}

// ====================测试代码=================
	public void test() {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		ListNode result = detectCycle2(node1);
		System.out.println(result.val);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

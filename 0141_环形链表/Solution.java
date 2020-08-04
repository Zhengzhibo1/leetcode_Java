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

// ====================算法实现====================
	// 1 双指针
	// 时间复杂度O(n)，n为节点数
	// 空见复杂度O(1)
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode index1 = head.next;
		if (index1 == null) {
			return false;
		}
		ListNode index2 = index1.next;

		while (index1 != null && index2 != null) {
			if (index1 == index2) {
				return true;
			}

			index1 = index1.next;
			index2 = index2.next;
			if (index2 != null) {
				index2 = index2.next;
			}

		}

		return false;
	}

	// 2 哈希表
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public boolean hasCycle2(ListNode head) {
		Set<ListNode> set = new HashSet<ListNode>();
		ListNode curNode = head;

		while (curNode != null) {
			if (set.contains(curNode)) {
				return true;
			} else {
				set.add(curNode);
			}
			curNode = curNode.next;
		}

		return false;
	}

// ====================测试代码====================
	public void test() {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		boolean result = hasCycle(node1);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

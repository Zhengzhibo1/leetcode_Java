import java.util.Stack;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现==================
	// 1 利用栈进行比对
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(n)，利用栈
	public boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode curNode = head;
		while (curNode != null) {
			stack.add(curNode);
			curNode = curNode.next;
		}

		curNode = head;
		while (curNode != null) {
			ListNode tempNode = stack.pop();
			if (curNode.val != tempNode.val) {
				return false;
			}
			curNode = curNode.next;
		}

		return true;
	}

	// 2 翻转后半部分链表进行比较
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public boolean isPalindrome2(ListNode head) {
		if (head == null) {
			return true;
		}

		boolean result = true;
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;

		while (result && p2 != null) {
			if (p1.val != p2.val) {
				result = false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		// 把链表还原
		firstHalfEnd.next = reverseList(secondHalfStart);
		return result;
	}

	// 寻找链接中间
	public ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	// 翻转链表
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

// ====================测试代码==================
	public void test() {
		ListNode node11 = new ListNode(1);
		ListNode node21 = new ListNode(2);
		ListNode node12 = new ListNode(1);
		ListNode node22 = new ListNode(2);

		node11.next = node21;
		node21.next = node22;
		node22.next = node12;

		boolean res = isPalindrome2(node11);
		System.out.println(res);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

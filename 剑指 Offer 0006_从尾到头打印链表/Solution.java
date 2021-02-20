public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ===================算法实现====================
	// 方法 二次遍历
	// 时间复杂度O(n)，n为链表的长度
	// 空间复杂度O(1)
	public int[] reversePrint(ListNode head) {

		// 一次遍历求长度
		int length = 0;
		ListNode tempNode = head;
		while (tempNode != null) {
			length++;
			tempNode = tempNode.next;
		}

		// 二次遍历写结果
		int[] result = new int[length];
		int index = length - 1;
		tempNode = head;
		while (tempNode != null) {
			result[index--] = tempNode.val;
			tempNode = tempNode.next;
		}

		return result;
	}

// ===================测试代码=====================
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);

		node1.next = node3;
		node3.next = node2;

		int[] result = reversePrint(node1);
		for (int i : result) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

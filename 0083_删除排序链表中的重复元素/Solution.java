public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

// ===================算法实现=======================
	// 方法 一次遍历
	// 时间复杂度O(n)，n为节点数
	// 空间复杂度O(1)
	public ListNode deleteDuplicates(ListNode head) {

		// 边界条件判断
		if (head == null) {
			return head;
		}

		ListNode curNode = head;
		while (curNode != null) {
			int val = curNode.val;

			ListNode nextNode = curNode.next;
			while (nextNode != null) {
				if (nextNode.val != val) {
					break;
				}
				nextNode = nextNode.next;
			}

			curNode.next = nextNode;
			curNode = curNode.next;
		}

		return head;
	}

// ===================测试代码=======================
	public void test() {
		ListNode node5 = new ListNode(3, null);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(2, node4);
		ListNode node2 = new ListNode(1, node3);
		ListNode node1 = new ListNode(1, node2);

		ListNode result = deleteDuplicates(node1);
		while (result != null) {
			System.out.print(result.val + "\t");
			result = result.next;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

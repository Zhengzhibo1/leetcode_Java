public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

// ====================算法实现=====================
	// 1 归并排序，迭代
	// 时间复杂度O(NlogN)，其中N为链表长度
	// 空间复杂度O(1)
	public ListNode sortList(ListNode head) {

		// 边界条件判定
		if (head == null || head.next == null) {
			return head;
		}

		// 求得链表长度
		int length = 0;
		for (ListNode temp = head; temp != null; temp = temp.next) {
			length++;
		}

		// 创建哑节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		// 外层大循环，分块，1个一块，2个一块，4个一块...
		// 块的大小为2次幂，故时间复杂度为O(logN)，N为链表长度
		for (int i = 1; i < length; i = 2 * i) {
			ListNode tempNode = dummy;
			// 归并
			// 内循环，每个节点遍历一次，时间复杂度为O(n)
			// j + i < length，表示要归并的两个块的起始节点在链表内
			// 否则表示一整段，不用归并
			for (int j = 0; j + i < length; j = j + 2 * i) {
				// 首先寻找两块的起始节点
				ListNode first = tempNode.next;
				ListNode second = first;
				for (int k = 0; k < i; ++k) {
					second = second.next;
				}

				// 开始归并
				// 第二块数量可能小于i，故增加判断条件second != null
				int f = 0, s = 0;
				while (f < i && s < i && second != null) {
					if (first.val < second.val) {
						tempNode.next = first;
						tempNode = tempNode.next;
						first = first.next;
						f++;
					} else {
						tempNode.next = second;
						tempNode = tempNode.next;
						second = second.next;
						s++;
					}
				}

				// 处理归并之后剩余的节点
				while (f < i) {
					tempNode.next = first;
					tempNode = tempNode.next;
					first = first.next;
					f++;
				}

				while (s < i && second != null) {
					tempNode.next = second;
					tempNode = tempNode.next;
					second = second.next;
					s++;
				}

				// 更新tempNode.next指向下一块的起点
				tempNode.next = second;
			}
		}

		return dummy.next;
	}
	
	// 2 归并排序，递归
	// 时间复杂度O(NlogN)，其中N为链表长度
	// 空间复杂度O(logN)，由递归深度决定
	public ListNode sortList2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// 分割节点
		ListNode tempNode = slow.next;
		slow.next = null;
		ListNode left = sortList2(head);
		ListNode right = sortList2(tempNode);
		
		// 创建哑节点
		ListNode dummy = new ListNode(-1);
		ListNode begin = dummy;
		// 开始归并
		while(left != null && right != null) {
			if(left.val < right.val) {
				begin.next = left;
				left = left.next;
			}else {
				begin.next = right;
				right = right.next;
			}
			begin =  begin.next;
		}
		
		// 处理合并完的剩余节点
		begin.next = left != null ? left : right;
		
		return dummy.next;
	}

// ====================测试代码=====================
	public void test() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node4.next = node2;
		node2.next = node1;
		node1.next = node3;

		ListNode result = sortList(node4);
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

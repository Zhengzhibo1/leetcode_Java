public class Solution {

// ====================算法实现==================
	//总结：1、时间复杂度：两种方法一样
	//		2、空间复杂度：两种方法一样
	//		3、第一种方法步骤略多，比较麻烦，
	// 且注意本题为大数问题，最好用字符数组进行表示，其他整数类型均会产生溢出问题
	//内部类：链表结构
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 1、方法1：大数问题，字符数组表示，有点蠢第一版想到的方法。
	// 链表转字符数组，然后进行字符数组中数字的运算，最后再将字符数组转换成链表
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// 1、先把两个数从链表中提取出来
		int count1 = 0;
		ListNode tempNode = l1;
		while (tempNode != null) {
			count1++;
			tempNode = tempNode.next;
		}

		int count2 = 0;
		tempNode = l2;
		while (tempNode != null) {
			count2++;
			tempNode = tempNode.next;
		}

		char[] num1 = new char[count1];
		char[] num2 = new char[count2];

		listTochar(l1, num1, count1 - 1);
		listTochar(l2, num2, count2 - 1);

		// 2、对两个数进行求和
		char[] sum = getSum(num1, num2);

		// 3、将求和得到的数用链表表示
		ListNode result = charToList(sum, sum.length - 1);
		return result;
	}

	public void listTochar(ListNode node, char[] nums, int index) {

		if (node == null) {
			return;
		}
		nums[index] = (char) ('0' + node.val);
		listTochar(node.next, nums, --index);

	}

	public char[] getSum(char[] nums1, char nums2[]) {

		int carry = 0;
		int sum = 0;
		char[] num1;
		char[] num2;
		// 总是让num1的长度大于等于num2的长度
		// 方便后面的计算。
		if (nums1.length >= nums2.length) {
			num1 = nums1;
			num2 = nums2;
		} else {
			num1 = nums2;
			num2 = nums1;
		}

		int length1 = num1.length;
		int length2 = num2.length;

		for (int i = 1; i <= length2; ++i) {
			sum = num1[length1 - i] + num2[length2 - i] - '0' - '0';
			sum += carry;
			carry = 0;
			if (sum > 9) {
				carry = 1;
				sum -= 10;
			}
			num1[length1 - i] = (char) ('0' + sum);
		}

		for (int i = 1; i <= length1 - length2; ++i) {
			if (carry == 0) {
				break;
			}

			sum = num1[length1 - length2 - i] + carry - '0';
			carry = 0;
			if (sum > 9) {
				carry = 1;
				sum -= 10;
			}
			num1[length1 - length2 - i] = (char) ('0' + sum);
		}

		if (carry == 1) {
			char[] num = new char[length1 + 1];
			num[0] = '1';
			for (int i = 0; i < length1; ++i) {
				num[1 + i] = num1[i];
			}

			return num;
		}

		return num1;
	}

	public ListNode charToList(char[] num, int index) {

		if (index == -1) {
			return null;
		}
		ListNode nextNode = charToList(num, index - 1);
		ListNode node = new ListNode(num[index] - '0');
		node.next = nextNode;
		return node;
	}

	// 2、直接操作链表
	// 官网给出的题解，看后恍然大悟，第一种方法自己想复杂了。
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode tempNode1 = l1;
		ListNode tempNode2 = l2;
		ListNode currNode = dummyHead;
		int sum = 0;
		int carry = 0;
		int temp1 = 0;
		int temp2 = 0;

		while (tempNode1 != null || tempNode2 != null) {
			temp1 = (tempNode1 == null) ? 0 : tempNode1.val;
			temp2 = (tempNode2 == null) ? 0 : tempNode2.val;

			sum = temp1 + temp2 + carry;
			carry = sum / 10;
			currNode.next = new ListNode(sum % 10);
			currNode = currNode.next;

			if (tempNode1 != null) {
				tempNode1 = tempNode1.next;
			}
			if (tempNode2 != null) {
				tempNode2 = tempNode2.next;
			}
		}

		if (carry == 1) {
			currNode.next = new ListNode(1);
		}
		return dummyHead.next;
	}

// ======================测试代码===================
	public void test() {
		ListNode l1 = new ListNode(9);

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(9);
		ListNode n5 = new ListNode(9);
		ListNode n6 = new ListNode(9);
		ListNode n7 = new ListNode(9);
		ListNode n8 = new ListNode(9);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;

		ListNode result = addTwoNumbers(n1, l1);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}

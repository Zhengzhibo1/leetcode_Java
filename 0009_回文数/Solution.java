public class Solution {

// ====================算法实现=================
	// 1、完全翻转整个数字在比较，缺点可能产生溢出
	// 时间复杂度：O(logN)，每次迭代都将输入除以10
	// 空间复杂度：O(1)，仅需常数空间存放变量
	public boolean isPalindrome(int x) {

		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int temp = x;
		int num = 0;
		while (temp != 0) {
			num = num * 10 + temp % 10;
			temp /= 10;
		}
		if (num == x) {
			return true;
		}

		return false;
	}

	// 2、转换成字符串对比字符串首尾，缺点需要额外非常量空间
	// 时间复杂度：O(logN)，每次尾巴往前移比较，相当于除以10
	// 空间复杂度：O(logN)，需要这么多空间存放字符串
	public boolean isPalindrome2(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		String num = String.valueOf(x);
		int index1 = 0;
		int index2 = num.length() - 1;
		while (index1 < index2) {
			if (num.charAt(index1) != num.charAt(index2)) {
				return false;
			}
			index1++;
			index2--;
		}
		return true;
	}

	// 3、仅翻转数字的一半，然后进行比较
	// 时间复杂度：O(logN)，每次迭代都将输入除以10
	// 空间复杂度：O(1)，仅需常数空间存放变量
	public boolean isPalindrome3(int x) {
		// x为负数，或者x的个位为0且x不等于0，例如 -121，120，不可能是回文数
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int revertedNumber = 0;

		// 仅翻转一半，防止溢出 ，例如1221 翻转完后12，12，例如12321，翻转完后12，123
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		// 1221，12，12，12321，12，123
		return x == revertedNumber || x == revertedNumber / 10;
	}

// ===================测试代码==================
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome(121));

	}

}

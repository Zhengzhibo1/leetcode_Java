public class Solution {

// ====================算法实现===================
	// 总结：
	// 时间复杂度O(n),其中n为字符串长度
	// 空间复杂度O(n),需要一个额外的char数组，便于计算
	public int myAtoi(String str) {

		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] strs = str.toCharArray();
		// 找到第一个不是空格符的字符位置
		int firstNotSpace = 0;
		for (firstNotSpace = 0; firstNotSpace < strs.length - 1; ++firstNotSpace) {
			if (strs[firstNotSpace] != ' ') {
				break;
			}
		}
		// 防止到了尾端而结束的for循环，再次判断
		if (strs[firstNotSpace] == ' ') {
			return 0;
		}

		// 第一个非空字符为数组最后一位
		if (firstNotSpace == strs.length - 1) {
			if (strs[firstNotSpace] >= '0' && strs[firstNotSpace] <= '9') {
				return strs[firstNotSpace] - '0';
			} else {
				return 0;
			}
		}

		// 至此已经找到第一个非空格符字符的位置且不是最后一位
		int endOfNum = 0;
		if (strs[firstNotSpace] == '+' || strs[firstNotSpace] == '-') {
			// 判断符号位后面是否为数字，若不是数字，则非法输入，返回0
			if (strs[firstNotSpace + 1] < '0' || strs[firstNotSpace + 1] > '9') {
				return 0;
			} else {
				endOfNum = firstNotSpace + 1;
				// 找到数字的末尾
				while ((endOfNum + 1) < strs.length && strs[endOfNum + 1] >= '0' && strs[endOfNum + 1] <= '9') {
					endOfNum++;
				}
				// 转换成数字
				return myAtoiCore(strs, firstNotSpace, endOfNum, true);
			}
		} else if (strs[firstNotSpace] >= '0' && strs[firstNotSpace] <= '9') {
			endOfNum = firstNotSpace;
			while ((endOfNum + 1) < strs.length && strs[endOfNum + 1] >= '0' && strs[endOfNum + 1] <= '9') {
				endOfNum++;
			}
			// 转换成数字
			return myAtoiCore(strs, firstNotSpace, endOfNum, false);
		}

		return 0;
	}

	public int myAtoiCore(char[] strs, int begin, int end, boolean symbol) {

		// 是否减号
		boolean minus = false;

		// 表示要转换的数字带有加号或者减号
		if (symbol == true) {
			char s = strs[begin];
			if (s == '-') {
				minus = true;
			}
			begin++;
		}

		long num = 0;
		int flag = 1; // 符号标志位
		for (int i = begin; i <= end; ++i) {
			flag = minus ? -1 : 1;
			num = num * 10 + flag * (strs[i] - '0');

			// 判断是否产生溢出
			if (!minus && num > 0x7fffffff) {
				return 0x7fffffff;
			} else if (minus && num < 0x80000000) {
				return 0x80000000;
			}
		}

		return (int) num;
	}

// ====================算法实现===================
	public static void main(String[] args) {
		Solution s = new Solution();
		// String str = "-91283472332";
		String str = "9223372036854775808";
		int result = s.myAtoi(str);
		System.out.println(result);

	}

}

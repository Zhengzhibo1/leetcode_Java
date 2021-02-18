public class Solution {

// ===================算法实现======================
	// 方法 寻找众数
	// 时间复杂度O(n)，n位字符串的长度
	// 空间复杂度O(n)，需要字符数组存放中间结果
	public String reorganizeString(String S) {

		// 存放每个字母出现的次数
		int[] counts = new int[26];
		char[] res = S.toCharArray();
		for (int i = 0; i < res.length; ++i) {
			counts[S.charAt(i) - 'a']++;
		}

		// 找到出现次数最多的字符
		int max = 0;
		int maxIndex = 0;
		// 阈值
		int threshold = res.length + 1 >> 1;
		for (int i = 0; i < 26; i++) {
			if (counts[i] > max) {

				max = counts[i];
				maxIndex = i;

				// 判断出现次数最多的字符是否超过阈值
				if (max > threshold) {
					return "";
				}
			}
		}

		// 如果出现次数最多的字符的次数没有超过阈值，说明符合题意
		// 将出现次数最多的字符摆在下标偶数位置
		int index = 0;
		while (counts[maxIndex] > 0) {
			res[index] = (char) (maxIndex + 'a');
			index += 2;
			counts[maxIndex]--;
		}

		// 填充其他字符
		for (int i = 0; i < counts.length; ++i) {
			while (counts[i] > 0) {

				// 如果填充到了结尾，就从头奇数下标开始填充
				if (index >= res.length) {
					index = 1;
				}
				res[index] = (char) (i + 'a');
				index += 2;
				counts[i]--;
			}
		}

		return new String(res);
	}

// ===================测试代码======================
	public void test() {
		String S = "aab";
		String result = reorganizeString(S);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

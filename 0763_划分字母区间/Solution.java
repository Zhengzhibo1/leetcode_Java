import java.util.ArrayList;
import java.util.List;

public class Solution {

// ===================算法实现====================
	// 方法 一次遍历 + 数组存每个字母的最后位置
	// 时间复杂度O(n)，n位字符串的长度
	// 空间复杂度O(1)，因为小写字母最多26个
	public List<Integer> partitionLabels(String S) {

		List<Integer> resultList = new ArrayList<Integer>();
		if (S == null || S.length() == 0) {
			return resultList;
		}

		// 用于存放不同字符最后出现的位置
		int[] last = new int[26];

		int length = S.length();
		for (int i = 0; i < length; ++i) {
			last[S.charAt(i) - 'a'] = i;
		}

		int start = 0, end = 0;
		for (int i = 0; i < length; ++i) {

			end = Math.max(end, last[S.charAt(i) - 'a']);

			if (i == end) {
				resultList.add(end - start + 1);
				start = end + 1;
			}
		}

		return resultList;
	}

// ===================测试代码====================
	public void test() {
		String S = "ababcbacadefegdehijhklij";
		List<Integer> resultList = partitionLabels(S);
		for (int i : resultList) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

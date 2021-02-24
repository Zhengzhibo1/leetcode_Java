import java.util.HashSet;
import java.util.Set;

public class Solution {

// ===================算法实现=====================
	// 方法 回溯，利用set去重
	// 时间复杂度O(n!)，共有n！种方案
	// 空间复杂度O(n!)，set所需空间
	public String[] permutation(String s) {

		// 边界条件判断
		if (s == null || s.length() == 0) {
			return new String[0];
		}

		Set<String> set = new HashSet<String>();
		premutationCore(s.toCharArray(), 0, set);

		String[] result = new String[set.size()];
		int index = 0;
		for (String temp : set) {
			result[index] = temp;
			index++;
		}

		return result;
	}

	private void premutationCore(char[] chars, int start, Set<String> set) {

		// 如果到达最后一个字符，记录结果
		if (start == chars.length - 1) {
			set.add(String.valueOf(chars));
		}

		for (int i = start; i < chars.length; ++i) {
			char temp = chars[start];
			chars[start] = chars[i];
			chars[i] = temp;

			premutationCore(chars, start + 1, set);

			temp = chars[start];
			chars[start] = chars[i];
			chars[i] = temp;
		}
	}

// ===================测试代码=====================
	public void test() {
		String s = "abc";
		String[] result = permutation(s);
		for (String temp : result) {
			System.out.print(temp + "\t");
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

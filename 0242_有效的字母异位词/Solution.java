import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

// ===================算法实现=====================
	// 1 哈希表
	// 时间复杂度O(n)，n为字符串的长度
	// 空间复杂度O(1)，因为仅有26个小写字母
	public boolean isAnagram(String s, String t) {

		int sLength = s.length();
		int tLength = t.length();

		if (sLength != tLength) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < sLength; ++i) {
			char temp = s.charAt(i);
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}

		for (int i = 0; i < tLength; ++i) {
			char temp = t.charAt(i);
			if (!map.containsKey(temp) || map.get(temp) == 0) {
				return false;
			}
			map.put(temp, map.get(temp) - 1);
		}

		return true;
	}

	// 2 排序
	// 时间复杂度O(n log n)，排序时间复杂度
	// 空间复杂度O(n)，char数组，排序为O(log n)
	public boolean isAnagram2(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();

		Arrays.sort(str1);
		Arrays.sort(str2);

		return Arrays.equals(str1, str2);
	}

// ===================测试代码=====================
	public void test() {
		String s = "anagram";
		String t = "nagaram";
		boolean result = isAnagram2(s, t);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

import java.util.HashMap;
import java.util.Map;

public class Solution {

// ===================算法实现=====================
	// 方法 一次遍历+字典
	// 时间复杂度O(n)，n为pattern的长度
	// 空间复杂度O(n)
	public boolean wordPattern(String pattern, String s) {

		Map<Character, String> map1 = new HashMap<Character, String>();
		Map<String, Character> map2 = new HashMap<String, Character>();

		String strs[] = s.split(" ");

		// 如果长度不相等，则返回false
		int length1 = pattern.length();
		int length2 = strs.length;
		if (length1 != length2) {
			return false;
		}

		for (int i = 0; i < length1; ++i) {

			if (map1.containsKey(pattern.charAt(i)) && !map1.get(pattern.charAt(i)).equals(strs[i])) {
				return false;
			}

			if (map2.containsKey(strs[i]) && map2.get(strs[i]) != pattern.charAt(i)) {
				return false;
			}

			map1.put(pattern.charAt(i), strs[i]);
			map2.put(strs[i], pattern.charAt(i));
		}

		return true;
	}

// ===================测试代码=====================
	public void test() {
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean result = wordPattern(pattern, str);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

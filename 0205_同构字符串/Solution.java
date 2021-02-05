import java.util.HashMap;
import java.util.Map;

public class Solution {

// ====================算法实现===================
	// 方法 双字典+一次遍历
	// 时间复杂度O(n)，n为字符串长度
	// 空间复杂度O(n)
	public boolean isIsomorphic(String s, String t) {

		// 边界条件判断

		Map<Character, Character> map1 = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();

		int length = s.length();
		for (int i = 0; i < length; ++i) {

			char temp1 = s.charAt(i);
			char temp2 = t.charAt(i);

			if ((map1.containsKey(temp1) && temp2 != map1.get(temp1))
					|| (map2.containsKey(temp2) && temp1 != map2.get(temp2))) {
				return false;
			}

			map1.put(temp1, temp2);
			map2.put(temp2, temp1);
		}

		return true;
	}

// ====================测试代码===================
	public void test1() {
		String s = "egg";
		String t = "add";
		boolean result = isIsomorphic(s, t);
		System.out.println(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test1();

	}

}

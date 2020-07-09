import java.util.HashMap;
import java.util.Map;

public class Solution {

// ====================算法实现================
	// 总结：
	// 1、时间复杂度O(n)，其中n为字符串s的长度
	// 1、空间复杂度O(1)，仅需用个哈希表存在相关符合表示的数值
	// 2、时间复杂度O(n)，其中n为字符串s的长度
	// 2、空间复杂度O(1)

	// 1、哈希表
	public int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);

		int sum = 0;
		for (int i = 0; i < s.length();) {
			if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
				sum += map.get(s.substring(i, i + 2));
				i += 2;
			} else {
				sum += map.get(s.substring(i, i + 1));
				i++;
			}
		}

		return sum;
	}

	// 2、switch-case
	public int romanToInt2(String s) {
		int sum = 0;
		int preNum = getValue(s.charAt(0));
		for (int i = 1; i < s.length(); ++i) {
			int num = getValue(s.charAt(i));
			if (preNum < num) {
				sum -= preNum;
			} else {
				sum += preNum;
			}

			preNum = num;
		}
		sum += preNum;

		return sum;
	}

	public int getValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

// ====================测试代码================
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "MCMXCIV";
		int result = s.romanToInt2(str);
		System.out.println(result);

	}

}

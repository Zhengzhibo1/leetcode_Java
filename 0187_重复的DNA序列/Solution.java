import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

// ====================算法实现=====================
	// 方法 一次遍历 + 哈希表
	// 时间复杂度O(L(N-L))，N为字符串的长度，L为目标子串的长度
	// 空间复杂度O((N-L)L)
	public List<String> findRepeatedDnaSequences(String s) {

		List<String> resultList = new ArrayList<String>();
		Set<String> resultSet = new HashSet<String>();
		if (s == null || s.length() <= 10) {
			return resultList;
		}

		int length = s.length();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i <= length - 10; ++i) {
			String temp = s.substring(i, i + 10);

			if (!set.contains(temp)) {
				set.add(temp);
			} else {
				resultSet.add(temp);
			}
		}

		for (String temp : resultSet) {
			resultList.add(temp);
		}

		return resultList;
	}

// ====================测试代码=====================
	public void test() {
		String s = "AAAAAAAAAAA";
		List<String> resultList = findRepeatedDnaSequences(s);
		for (String temp : resultList) {
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}

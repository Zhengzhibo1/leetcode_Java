import java.util.ArrayList;
import java.util.List;

public class Solution {

// ====================算法实现=====================
	// 1 
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public List<String> fizzBuzz(int n) {

		List<String> result = new ArrayList<String>();
		if (n == 0) {
			return result;
		}

		for (int i = 1; i <= n; ++i) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					result.add("FizzBuzz");
				} else {
					result.add("Fizz");
				}
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}

		return result;
	}

// ====================测试代码=====================
	public void test() {
		int n = 15;
		List<String> result = fizzBuzz(n);
		for (String s : result) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();

	}

}
